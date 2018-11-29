/*
During his interview, Shil came across a very difficult problem. The problem is as follows:

A matrix V consisting of N rows and M columns is called beautiful if and only if it satisfies the following two conditions:

1) Every cell of the matrix contains distinct natural number less or equal to N*M. natural numbers = 1,2,3,...
2) For any two cells of the matrix, (i1,j1) and (i2,j2), if (i1^j1) > (i2^j2) then v[i1][j1] > v[i2][j2] .

^ denotes Bitwise XOR operation.

Note that 1 ≤ i1,i2 ≤ N and 1 ≤ j1,j2 ≤ M.

Given N and M , you have to calculatethe total number of beautiful matrices of size N x M. Since the problem is being 
very difficult for Shil to solve, he asks for your help.

Input format:
The Input consists of two integers N and M representing the number of rows and columns respectively.

Output format:
Output the total number of Beautiful Matrices of size N x M. Since, this answer can be large, output it modulo 10e9+7.

Constraints:
1 ≤ N,M ≤ 1000

SAMPLE INPUT 
2 2
SAMPLE OUTPUT 
4
Explanation
The four possible matrices are:
[1 3] | [2 3] | [1 4] | [2 4]
[4 2] | [4 1] | [3 2] | [3 1]
*/

import java.util.*;
class TestClass {
    static int mod = 1000000007;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        s.close();

        /*
        Explanation (in LaTeX documentation): For any entry index $(i,j)$ of an $N\times M$ matrix, the maximum value of 
        $i$ XOR $j$ is between $0$ and $2^k-1$ where $k$ denotes the smallest integer such that $2^k>\max\{N,M\}$. This is
        because the maximum value $M$ of $i$ or $j$ can be at most $\max\{N,M\}$, and hence the binary expansion of $M$ has
        at most $k-1$ digits. Taking XOR of $M$ with another integer smaller than $M$ thus produces an integer with at most
        $k-1$ digits. 
        
        Since $N,M\leq 1000$, the upper bound for $k$ is $10$, so the XOR values of all entry pairs $(i,j)$ lies in the closed
        interval $[0,1023]$. Now let count[] be an array of size $1024$ such that entry $x$ denotes the number of ordered entry 
        pairs $(i,j)$ with $i$ XOR $j$ equal to $x$ for all integers $0\leq x\leq 1023$. Note that the sum of all the entries of 
        count[] is precisely $N\cdot M$ because there are $N\times M$ entry pairs in total (i.e. the matrix has $N\cdot M$ 
        entries). Since the entries of the matrix is a permutation of the numbers $1,2,...,N\cdot M$, the array count[] partition 
        these numbers into $p$ parts, says $P_1,P_2,\dots,\P_p$ where $p$ denotes the number of non-zero entries in count[].
        Let $P_i$ correspond to entry $e_i$ in count[] for all $1\leq i\leq p$, so that $P_i =$ count[$e_i$]. Those integers 
        in $P_i$ must precisely fill the entries the matrix with entry pair XOR value equal to $e_i$ and there is precisely $P_i!$ 
        ways to fill them. Hence, the total number of $N\times M$ beautiful matrices is precisely $P_1!P_2!\cdots P_p!$. 
        */
        
        int[] count = new int[1024];
        long[] fact = new long[1000000];
        fact[0] = 1;
        for (int i=1; i<=N*M; i++){
            fact[i] = (i*fact[i-1])%mod;
        }
        
        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                count[i^j]++;
            }
        }
        
        long res = 1;
        for (int i=0; i<1024; i++){
            if (count[i]!=0) res = (res*fact[count[i]])%mod;
        }
       
        System.out.println(res);
    }
}
