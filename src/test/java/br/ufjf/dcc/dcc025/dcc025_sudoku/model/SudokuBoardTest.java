package br.ufjf.dcc.dcc025.dcc025_sudoku.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SudokuBoardTest {
    @Test
    public void givenNewSudokuBoard_whenGetCell_thenReturnCellWithZeroValue() {
        SudokuBoard board = new SudokuBoard();
        assertEquals(0, board.getCell(0, 0).getValue());
    }

    @Test
    public void givenSudokuBoard_whenSetCell_thenCellValueIsUpdated() {
        SudokuBoard board = new SudokuBoard();
        board.setCell(0, 0, 5);
        assertEquals(5, board.getCell(0, 0).getValue());
    }

    @Test
    public void givenSudokuBoard_whenIsValidMove_thenReturnTrueForValidMove() {
        SudokuBoard board = new SudokuBoard();
        assertTrue(board.isValidMove(0, 0, 5));
    }

    @Test
    public void givenSudokuBoard_whenIsValidMove_thenReturnFalseForInvalidMove() {
        SudokuBoard board = new SudokuBoard();
        board.setCell(0, 0, 5);
        assertFalse(board.isValidMove(0, 1, 5));
    }

    @Test
    public void givenSudokuBoard_whenIsComplete_thenReturnFalseForIncompleteBoard() {
        SudokuBoard board = new SudokuBoard();
        assertFalse(board.isComplete());
    }

    @Test
    public void givenSudokuBoard_whenIsComplete_thenReturnTrueForCompleteBoard() {
        SudokuBoard board = new SudokuBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.setCell(row, col, 1);
            }
        }
        assertTrue(board.isComplete());
    }
}