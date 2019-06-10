/*
Three stones are on a number line at positions a, b, and c.

Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone),
and move it to an unoccupied position between those endpoints.  Formally, let's say the stones are currently
at positions x, y, z with x < y < z.  You pick up the stone at either position x or position z, and move
that stone to an integer position k, with x < k < z and k != y.

The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.

When the game ends, what is the minimum and maximum number of moves that you could have made?
Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]



Example 1:

Input: a = 1, b = 2, c = 5
Output: [1,2]
Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
Example 2:

Input: a = 4, b = 3, c = 2
Output: [0,0]
Explanation: We cannot make any moves.
Example 3:

Input: a = 3, b = 5, c = 1
Output: [1,2]
Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.


Note:

1 <= a <= 100
1 <= b <= 100
1 <= c <= 100
a != b, b != c, c != a

 */

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int C = Math.max(a,Math.max(b,c));
        int A = Math.min(a,Math.min(b,c));
        int B = a+b+c - A - C;

        int max = C - A - 2;
        int min = 0;
        if (C - B>2 && B-A>2) {
            min = 2;
            return new int[]{min, max};
        }
        else if ((C-B==1 && B-A>1) || C-B==2 || (B-A==1 && C-B>1) || B-A==2){
            min = 1;
            return new int[]{min, max};
        }
        else return new int[]{min, max};
    }
}
