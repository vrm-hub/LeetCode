class Solution {
    int ROWS, COLS;
    boolean[][] b;
    private boolean dfs(char[][] board, String word, int row, int col, int count) {
        if(count == word.length()) {
            return true;
        }

        if(row >= ROWS || row < 0 || col >= COLS || col < 0 || b[row][col] || board[row][col] != word.charAt(count)) {
            return false;
        }

        b[row][col] = true;
        boolean found = dfs(board, word, row+1, col, count + 1) ||
        dfs(board, word, row-1, col, count + 1) ||
        dfs(board, word, row, col-1, count + 1) ||
        dfs(board, word, row, col+1, count + 1);
        b[row][col] = false;

        return found;
    }
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        b = new boolean[ROWS][COLS];

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }
}
