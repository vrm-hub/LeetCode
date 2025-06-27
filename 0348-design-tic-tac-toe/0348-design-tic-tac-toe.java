class TicTacToe {
    private char[][] board;
    private int n;

    public TicTacToe(int n) {
        this.board = new char[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        char symbol = player == 1 ? 'x' : 'o';
        board[row][col] = symbol;

        boolean win = true;
        // Check row
        for (int i = 0; i < n; i++) {
            if (board[row][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return player;

        // Check col
        win = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return player;

        // Check main diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return player;
        }

        // Check anti-diagonal
        if (row + col == n - 1) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return player;
        }

        return 0;
    }
}
