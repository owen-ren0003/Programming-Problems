/*
Travelling Salesman Problem (TSP): Given a set of cities and distance between every pair of cities, the problem is to find 
the shortest possible route that visits every city exactly once and returns to the starting point.Note the difference between 
Hamiltonian Cycle and TSP. The Hamiltoninan cycle problem is to find if there exist a tour that visits every city exactly 
once. Here we know that Hamiltonian Tour exists (because the graph is complete) and in fact many such tours exist, the 
problem is to find a minimum weight Hamiltonian Cycle.

For example, consider the graph with 4 location labelled 1,2,3,4 (nodes labelled 0,1,2,3) and adjacency matrix given by:
A = [[0,10,15,20],
    [10,0,35,25],
    [15,35,0,30],
    [20,25,30,0]].

A TSP tour in the graph is 1-2-4-3-1. The cost of the tour is 10+25+30+15 which is 80. We solve this problem using the
following algorithm from dynamic programming:

Given n+1 nodes labelled 0,1,2,...,n, we may assume by symmetry that the starting node is 0.

Let C(S,i) denote the cost of the of the minimum cost path visiting each node in the set S once starting at 0 and ending
at i, where S is a subset of {0,1,2...,n} such that 0 belongs to S.

The base case is C({0,i},j) = A[0][i] if and only if j=i and 0 otherwise. For S with 3 or more elements, we have the
recursion:

C(S,i) = min_{j in S, j!=0,i} (C(S\{i},j) + A[j][i])

To implement this, we need a way of representing S. We will do this with bitmask of size n, i.e. integers with binary
representation of length at most n. The bits that are 1 in the binary expansion will represent that this index belongs
to S. For example, if n = 4, a number N_S = (1101)_2 =  represents S = {0,1,2,4} (note that 0 is always in S, so we did not
need a bit mask of size n+1). Moreover, note that S\{i} is given N_S - (1<<(i-1)), for i=1,2,...,n. Now we can implement
the travelling salesman problem:

Note: The problem is a famous NP complete problem. There is no polynomial time know solution for this problem.
 */

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //starts at node 0. Find shortest path that traverses all the nodes and ends up back at 0.
        int[][] graph = {{0,10,15,20},{10,0,35,25},{15,35,0,30},{20,25,30,0}};
        int n = graph.length-1;
        //int n = 4;
        //int[][] graph = {{0,3,5,7,9},{3,0,4,6,8},{5,4,0,2,11},{7,7,2,0,13},{9,8,11,13,0}};

        //int n = 4;
        //int[][] graph = {{0,2,0,6,1},{1,0,4,4,2},{5,3,0,1,5},{4,7,2,0,1},{2,6,3,6,0}};

        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = graph[0][j+1];
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k+1][j+1] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k+1][j+1];
                                path[i][j] = k;
                            }
                        }
                    }
                }

                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int j=0; j<3; j++) {
            int cur = dp[(1 << n)-1][j] + graph[j+1][0];
            if (minPath> cur) minPath = cur;
        }
        System.out.println(last);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int curId = (1 << n) - 1;
        while (curId > 0) {
            stack.push(last+2); //+2 because in the for loop with started with i=0, and nodes are one less than location labels
            int temp = curId;
            curId -= (1 << last);
            last = path[temp][last];
        }
        stack.push(0);

        System.out.println(minPath);
        System.out.println(stack); //Travel starts from leftmost to rightmost location (if the adjacency matrix none symmetric).
    }
}
