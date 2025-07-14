class Solution {
    private static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int maxArea = 0;
    private int dfs(int[][] grid, int r, int c) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == 0) {
            return 0;
        }
        int area = 1;
        grid[r][c] = 0;

        for(int[] dir : dirs) {
            area += dfs(grid, r + dir[0], c + dir[1]);
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }
}
