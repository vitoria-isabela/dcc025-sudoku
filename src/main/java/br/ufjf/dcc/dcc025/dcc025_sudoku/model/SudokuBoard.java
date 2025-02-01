package br.ufjf.dcc.dcc025.dcc025_sudoku.model;

/**
 * The SudokuBoard class represents a 9x9 Sudoku game board. It provides methods to interact with
 * the board, such as retrieving and setting cell values, checking move validity, determining if
 * the board is complete, and printing the board's current state.
 * @author Vitória Isabela de Oliveira
 */
public class SudokuBoard {
    private SudokuCell[][] board;

    /**
     * Constructs a new SudokuBoard initialized with empty cells.
     */
    public SudokuBoard() {
        board = new SudokuCell[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = new SudokuCell(row, col, 0);
            }
        }
    }

    /**
     * Retrieves the SudokuCell at the specified row and column.
     *
     * @param row the row index of the cell (0-based index).
     * @param col the column index of the cell (0-based index).
     * @return the SudokuCell at the specified position.
     */
    public SudokuCell getCell(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets the value of the cell at the specified row and column.
     *
     * @param row the row index of the cell to set (0-based index).
     * @param col the column index of the cell to set (0-based index).
     * @param value the value to set in the cell.
     */
    public void setCell(int row, int col, int value) {
        board[row][col].setValue(value);
    }

    /**
     * Checks if placing a specified value at a given row and column is a valid move
     * according to Sudoku rules.
     *
     * @param row the row index for the move (0-based index).
     * @param col the column index for the move (0-based index).
     * @param value the value to place in the cell.
     * @return true if the move is valid; false otherwise.
     */
    public boolean isValidMove(int row, int col, int value) {
        // Check if the value already exists in the row or column, ignoring the current position
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i].getValue() == value) {
                return false;
            }
            if (i != row && board[i][col].getValue() == value) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((startRow + i != row || startCol + j != col) && board[startRow + i][startCol + j].getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Checks if the Sudoku board is complete, meaning all cells are filled with non-zero values.
     *
     * @return true if the board is completely filled; false otherwise.
     */
    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Prints the current state of the Sudoku board to the console, formatted with grid lines.
     */
    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col].getValue() + " ");
            }
            System.out.println();
        }
    }
}