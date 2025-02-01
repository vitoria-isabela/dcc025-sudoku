package br.ufjf.dcc.dcc025.dcc025_sudoku.service;

/**
 * The SudokuServiceInterface defines the contract for operations that can be performed on a Sudoku game board.
 * It provides methods for adding and removing moves, generating random numbers on the board, checking if the game is complete,
 * and printing the current state of the board.
 */
public interface SudokuServiceInterface {

    /**
     * Attempts to add a move to the Sudoku board at the specified row and column with the given value.
     *
     * @param row the row index where the move is to be placed (0-based index).
     * @param col the column index where the move is to be placed (0-based index).
     * @param value the value to be placed on the board (must be between 1 and 9 inclusive).
     * @return true if the move is successfully added and adheres to Sudoku rules; false otherwise.
     */
    boolean addMove(int row, int col, int value);

    /**
     * Populates the Sudoku board with a specified number of random numbers, ensuring that each placement
     * adheres to Sudoku rules.
     *
     * @param count the number of random numbers to generate and place on the board.
     */
    void generateRandomNumbers(int count);

    /**
     * Removes a move from the Sudoku board by setting the specified cell to zero.
     *
     * @param row the row index of the cell to be cleared (0-based index).
     * @param col the column index of the cell to be cleared (0-based index).
     * @return true after the move has been removed.
     */
    boolean removeMove(int row, int col);

    /**
     * Checks if the Sudoku game is complete, meaning all cells are filled correctly.
     *
     * @return true if the board is completely and correctly filled; false otherwise.
     */
    boolean isGameComplete();

    /**
     * Prints the current state of the Sudoku board to the console.
     */
    void printBoard();
}