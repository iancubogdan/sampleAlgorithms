package algorithms.backtracking;

public class BacktrackingAlgorithm {



    private static boolean usedInRow(SudokuBoard board, int row, int num) {
        int n = board.getN();

        for (int col = 0; col < n; col ++) {
            if (board.getBoard()[row][col] == num) {
                return true;
            }
        }
        return false;
    }


    private static boolean usedInCol(SudokuBoard board, int col, int num) {
        int n = board.getN();

        for (int row = 0; row < n; row ++) {
            if (board.getBoard()[row][col] == num) {
                return true;
            }
        }
        return false;
    }


    private static boolean usedInBox(SudokuBoard board, int row, int col, int num) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3 ; j++) {
                if (board.getBoard()[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean solveSudoku(SudokuBoard board) {
        int n = board.getN();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board.isUnnasigned(row, col)) { //board[row][col] == UNASSIGNED) {
                    for (int number = 1; number <= 9; number ++) {
                        if (isValid(board, row, col, number)) {
                            board.setValue(row, col, number);
//                            board[row][col] = number;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board.setUnnasigned(row, col);
//                                board[row][col] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isValid(SudokuBoard board, int row, int col, int number) {
        return !usedInRow(board, row, number)  &&  !usedInCol(board, col, number)  &&  !usedInBox(board, row, col, number);
    }

}
