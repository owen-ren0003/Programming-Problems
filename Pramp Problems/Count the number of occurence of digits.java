/*
Problem Description:

Given a nonnegative integer n and a digit (which is an integer) 1<=d<=9. Compute the number of occurences of d in the digits of the integer sequence 1,2,...,n. 

Example 1:
Input: 13, 1
Ans: 6
Explanation: 1 occurs in the integers 1, 10, 11, 12, 13 which gives a total of 6 times (as it occurs in 11 twice).

Example 2:
Input: 53, 5
Ans: 9
Explanation: 5 occurs in the integers 5, 15, 25, 35, 45, 50, 51, 52, 53 which gives a total of 9 times.

*/

/*
Solution Approach: Let n = d1 d2 ... dk, where di denotes the ith digit of n counting from the left for all 1<= i <= k where k denotes the number of digits of n. 
We proceed as follows:

First, we compute: 
c[r] = number of occurences of the digit d in all the positive integers with (r+1) digits or less (i.e. if r = 2, this would be computing the occurence of d
    in the integers 1,2,...,999).
for all 0<=r <= k-1. Note that c[r] is the same for any choice of d and all r.

Let ret denote the final answer. Now we compute the following:

1) Find the number of occurence of d in all numbers N<=n of with digits of the form
r1 d2 d3 ... dk
d1 r2 d3 ... dk
...
d1 d2 ...di-1 ri di+1 ... dk
...
d1 d2 ... rk-1 dk

where ri < di for all i=2,3,...,k. Add this number to ret.

2) for indices i=2,3,...,k: If we have di>d, we need to add 10^i to ret. Else if di = d, we need to add di+1 di+2 ... dk to ret. Else if d>di, continue.

3) finally add 1 if dk>=d, else continue.

the final answer is ret
*/

public class MyClass {
    public static void main(String args[]) {
        //test case 1:
        int n = 13;
        int d = 1;
        System.out.println(countDigit(n,d));
        
        //test case 2:
        n = 53;
        d = 5;
        System.out.println(countDigit(n,d));
    }
    
    private static int countDigit(int n, int d){
        if (n<10) return n>=d? 1:0;
        else {
            int nd = 0; //nd is the number of digits of n;
            
            //computes nd.
            int N = n;
            while (N>0) {
                nd++;
                N/=10;
            }
            N=n;
            
            //stores the digits of n in reverse order.
            int[] di = new int[nd]; 
            for (int i=0; i<nd; i++){
                di[i] = N%10;
                N/=10;
            }
            N=n;
            
            int[] after = new int[nd];
            int t=1;
            int temp = 0;
            for(int i=0; i<nd; i++){
                after[nd- i - 1] = temp;
                temp+=t*(N%10);
                t*=10;
                N/=10;
            }
            
            int[] c = new int[nd-1];
            int[] pow = new int[nd]; 
            c[0]=1; 
            pow[0] = 1;
            
            for (int i=1; i<nd-1; i++){
                pow[i] = 10*pow[i-1];
                c[i] = 10*c[i-1] + pow[i];
            }
            pow[nd-1] = 10*pow[nd-2];
            
            int ret=0;
            for (int i=nd-1; i>=0; i--){
                if (i>=1){
                    ret+= di[i]*c[i-1];
                    if (di[i]>d) ret+=pow[i];
                    if (di[i]==d) ret+=after[nd-i-1]+1;
                }
                else{
                    ret+=di[0]>=d?1:0;
                }
            }
            return ret;
        }
    }
}
