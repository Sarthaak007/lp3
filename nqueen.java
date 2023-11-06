
public class nqueen {
    public static void main(String[] args) {
        int n = 4; // Example for 4-Queens
        int[][] board = new int[n][n];

        // Place the first queen in the first row
        board[0][2] = 1; // Placing the first queen in the third column (0-indexed)

        // Start placing queens from the second row
        solveNQueens(board, 1, n);
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void solveNQueens(int[][] board, int row, int n) {
        if (row == n) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                solveNQueens(board, row + 1, n);
                board[row][col] = 0; // backtrack
            }
        }
    }
}
