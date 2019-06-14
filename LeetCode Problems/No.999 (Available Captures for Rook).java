/*
On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and
lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored
pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.


Example 1:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],
[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],
[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
In this example the rook is able to capture all the pawns.
Example 2:



Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],
[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],
[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 0
Explanation:
Bishops are blocking the rook to capture any pawn.
Example 3:



Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],
["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],
[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
The rook can capture the pawns at positions b5, d6 and f5.


Note:

board.length == board[i].length == 8
board[i][j] is either 'R', '.', 'B', or 'p'
There is exactly one cell with board[i][j] == 'R'
 */

public class Solution {
    public int numRookCaptures(char[][] board) {
        int x=-1, y=-1;
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int num = 0;
        for (int r=x+1; r<8; r++){
            if (board[r][y] == 'B'){
                break;
            }
            if (board[r][y] == 'p'){
                num++;
                break;
            }
        }

        for (int l=x-1; l>-1; l--){
            if (board[l][y] == 'B'){
                break;
            }
            if (board[l][y] == 'p'){
                num++;
                break;
            }
        }

        for (int u=y+1; u<8; u++){
            if (board[x][u] == 'B'){
                break;
            }
            if (board[x][u] == 'p'){
                num++;
                break;
            }
        }

        for (int d=y-1; d>-1; d--){
            if (board[x][d] == 'B'){
                break;
            }
            if (board[x][d] == 'p'){
                num++;
                break;
            }
        }

        return num;
    }
}
