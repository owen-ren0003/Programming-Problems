/*
Objective 
Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!

Task 
Given set . Find two integers,  and  (where ), from set  such that the value of  is the maximum possible and also less than a given integer, . In this case,  represents the bitwise AND operator.

Input Format

The first line contains an integer, , the number of test cases. 
Each of the  subsequent lines defines a test case as  space-separated integers,  and , respectively.

Constraints

Output Format

For each test case, print the maximum possible value of  on a new line.

Sample Input

3
5 2
8 5
2 2
Sample Output

1
4
0
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Solution Approach: 

Given the positive integer k, the smallest integer p!=k-1 such that p&(k-1) = k-1 is p = k|(k-1). Note that if
k-1 is even, then p=k. Hence, the answer is always k-1 when k-1 is even. For the case k-1 is odd, we see that 
if p>n, then the answer is k-2. Otherwise, the answer is k-1. It follows immediately that the answer is dependent
on whether p>n or p<=n. 
*/

public class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            if ((k|k-1)<=n){
                System.out.println(k-1);
            } else {
                System.out.println(k-2);
            }
        }

        scanner.close();
    }
}
