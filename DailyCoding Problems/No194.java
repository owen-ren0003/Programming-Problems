/*
Daily Coding Problem: Problem #194 [Easy]

This problem was asked by Facebook.

Suppose you are given two lists of n points, one list p1, p2, ..., pn on the line y = 0 and the other
list q1, q2, ..., qn on the line y = 1. Imagine a set of n line segments connecting each point pi to qi.
Write an algorithm to determine how many pairs of the line segments intersect.

 */

public class No194 {

    public static void main(String[] args) {
        double[] p = {-1, 2, 3};
        double[] q = {3, 2, 1};
        System.out.println(numIntersect(p, q));
    }

    /*
     p is the list containing the x-coordinates of p1, p2, ..., pn.
     q is the list containing the x-coordinates of q1, q2, ..., qn.

     p.length = n
     p[0].length = 2
     */
    public static int numIntersect(double[] p, double[] q){
        int n = p.length;
        int count = 0;

        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if ((p[j] > p[i] && q[j] < q[i]) || (p[j] < p[i] && q[j] > q[i])){
                    count++;
                } else if (p[j] == p[i] || q[j] == q[i]) {
                    count++;
                }
            }
        }

        return count;
    }
}
