public class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int mark = grid[r0][c0];
        dfs(grid, visited, r0, c0, mark);
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (visited[i][j]) {
                    if ((i == 0 || i == n-1 || j==0 || j==m-1)
                            || !(visited[i-1][j] && visited[i+1][j] && visited[i][j-1] && visited[i][j+1])) {
                        grid[i][j] = color;
                    }
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] grid, boolean[][] visited, int x, int y, int mark) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y]!= mark || visited[x][y] == true){
            return;
        }
        visited[x][y] = true;
        dfs(grid, visited, x-1, y, mark);
        dfs(grid, visited, x+1, y, mark);
        dfs(grid, visited, x, y-1, mark);
        dfs(grid, visited, x, y+1, mark);
    }
}
