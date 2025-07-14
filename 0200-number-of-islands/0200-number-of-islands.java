/*

*/
class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, 
                                               {0, 1}, {0, -1}};

    private void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == '0') return;
        
        grid[r][c] = '0';

        for(int i = 0; i < directions.length; i++) {
            dfs(grid, r + directions[i][0], c + directions[i][1]);
        }


    }
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int count = 0;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
