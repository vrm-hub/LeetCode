class Solution {
    private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        if (ROWS == 0 || COLS == 0) return;

        // Step 1: Mark all border-connected 'O's as '#'
        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][COLS - 1] == 'O') dfs(board, r, COLS - 1);
        }
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[ROWS - 1][c] == 'O') dfs(board, ROWS - 1, c);
        }

        // Step 2: Flip all remaining 'O's to 'X', and '#' back to 'O'
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // surrounded
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O'; // restore
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int ROWS = board.length, COLS = board[0].length;
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#'; // mark as visited and safe

        for (int[] dir : dirs) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
