/*
 Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

 Return the largest sum of the given array after partitioning.


 Example 1:

 Input: A = [1,15,7,9,2,5,10], K = 3
 Output: 84
 Explanation: A becomes [15,15,15,9,10,10,10]


 Note:

 1 <= K <= A.length <= 500
 0 <= A[i] <= 10^6

 */
public class Solution {
    public static void main(String[] args) {
        int[] A = {1,15,7,9,2,5,10};
        int K = 3;
        System.out.println(maxSumAfterPartitioning(A, K));
    }


    /**
     * Let dp[i] be the recorded maximum for elements $A[1], A[2], ... , A[N-1]$.
     * Then dp[i] = max_{1\leq k\leq K} dp[i-k] + k * curMaxk
     */
    public static int maxSumAfterPartitioning(int[] A, int K){
        int N = A.length;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            int curMaxk = 0;
            for (int k = 1; k <= K && i - k + 1 >=0; k++) {
                curMaxk = Math.max(curMaxk, A[i - k + 1]);
                dp[i] = Math.max(dp[i], ((i >= k)? dp[i-k] : 0) + k * curMaxk);
            }
        }

        return dp[N-1];
    }
}


