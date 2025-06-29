class Solution {
    boolean[] col, posDiag, negDiag;
    List<List<String>> res;
    char[][] board;

    private void backtrack(int n, int i) {
        if (i == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[i + c] || negDiag[i - c + n]) {
                continue;
            }
            col[c] = true;
            posDiag[i + c] = true;
            negDiag[i - c + n] = true;
            board[i][c] = 'Q';

            backtrack(n, i + 1);

            col[c] = false;
            posDiag[i + c] = false;
            negDiag[i - c + n] = false;
            board[i][c] = '.';
        }
    }
    
    public int totalNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        res = new ArrayList<>();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(n, 0);

        return res.size();
    }
}