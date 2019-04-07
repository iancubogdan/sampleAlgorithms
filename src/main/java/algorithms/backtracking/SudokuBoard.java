package algorithms.backtracking;


import lombok.Data;

@Data
public class SudokuBoard {

    private int[][] board;
    private int n;
    private static final int UNASSIGNED = 0;


    public SudokuBoard(int[][] board) {
        this.board = board;
        n = board.length;
    }


    public void setValue(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isUnnasigned(int row, int col) {
        return board[row][col] == UNASSIGNED;
    }

    public void setUnnasigned(int row, int col) {
        board[row][col] = UNASSIGNED;
    }

    public void displaySudoku() {
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n__________________________________________\n\n");
    }

}
