package br.ufjf.dcc.dcc025.dcc025_sudoku.service;

import br.ufjf.dcc.dcc025.dcc025_sudoku.model.SudokuBoard;
import java.util.Random;

/**
 * The SudokuService class provides various methods to interact with and manipulate a Sudoku game board.
 * It allows adding and removing moves, generating random numbers on the board, checking if the game is complete,
 * and printing the current state of the board.
 * 
 * This class implements the SudokuServiceInterface and relies on the SudokuBoard class to manage the board state.
 * @author Vitória Isabela de Oliveira
 */
public class SudokuService implements SudokuServiceInterface {
    private SudokuBoard board;
    private Random random;

    public SudokuService(SudokuBoard board) {
        this.board = board;
        this.random = new Random();
    }

    /**
    * Attempts to add a move to the Sudoku board at the specified row and column with the given value.
    *
    * @param row the row index where the move is to be placed (0-based index).
    * @param col the column index where the move is to be placed (0-based index).
    * @param value the value to be placed on the board (must be between 1 and 9 inclusive).
    * @return true if the move is successfully added and adheres to Sudoku rules; false otherwise.
    */
    @Override
    public boolean addMove(int row, int col, int value) {
        // Check if the value is within the valid range
        if (value < 1 || value > 9) {
            return false;
        }

        // Check if the move is valid according to Sudoku rules
        if (board.isValidMove(row, col, value)) {
            board.setCell(row, col, value);
            return true;
        }
        return false;
    }

    /**
    * Removes a move from the Sudoku board by setting the specified cell to zero.
    *
    * @param row the row index of the cell to be cleared (0-based index).
    * @param col the column index of the cell to be cleared (0-based index).
    * @return true after the move has been removed.
    */
    @Override
    public boolean removeMove(int row, int col) {
        board.setCell(row, col, 0);
        return true;
    }

    /**
    * Checks if the Sudoku game is complete, meaning all cells are filled correctly.
    *
    * @return true if the board is completely and correctly filled; false otherwise.
    */
    @Override
    public boolean isGameComplete() {
        return board.isComplete();
    }

    /**
    * Prints the current state of the Sudoku board to the console.
    */
    @Override
    public void printBoard() {
        board.printBoard();
    }

    /**
    * Populates the Sudoku board with a specified number of random numbers, ensuring that each placement
    * adheres to Sudoku rules.
    *
    * @param count the number of random numbers to generate and place on the board.
    */
    @Override
    public void generateRandomNumbers(int count) {
        // Clear the board by setting all cells to zero
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board.setCell(i, j, 0);
            }
        }

        // Place random numbers on the board
        for (int i = 0; i < count; i++) {
            int row, col, num;
            do {
                row = random.nextInt(9);
                col = random.nextInt(9);
                num = random.nextInt(9) + 1;
            } while (board.getCell(row, col).getValue() != 0 || !board.isValidMove(row, col, num));

            board.setCell(row, col, num);
        }
    }
}