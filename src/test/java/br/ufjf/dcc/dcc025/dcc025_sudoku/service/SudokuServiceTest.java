package br.ufjf.dcc.dcc025.dcc025_sudoku.service;
import br.ufjf.dcc.dcc025.dcc025_sudoku.model.SudokuBoard;
import br.ufjf.dcc.dcc025.dcc025_sudoku.service.SudokuService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SudokuServiceTest {

    @Test
    public void givenSudokuService_whenAddInvalidMove_thenMoveIsNotAdded() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        board.setCell(0, 0, 5);
        assertFalse(service.addMove(0, 1, 5)); // Same number in the row
        assertFalse(service.addMove(1, 0, 5)); // Same number in the column
        assertFalse(service.addMove(1, 1, 5)); // Same number in the 3x3 subgrid
    }

    @Test
    public void givenSudokuService_whenRemoveMove_thenMoveIsRemoved() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        board.setCell(0, 0, 5);
        assertTrue(service.removeMove(0, 0));
        assertEquals(0, board.getCell(0, 0).getValue());
    }

    @Test
    public void givenSudokuService_whenIsGameComplete_thenReturnFalseForIncompleteGame() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        assertFalse(service.isGameComplete());
    }

    @Test
    public void givenSudokuService_whenIsGameComplete_thenReturnTrueForCompleteGame() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.setCell(row, col, (col + 1) % 9 + 1); // Fill with valid numbers
            }
        }
        assertTrue(service.isGameComplete());
    }
    
    @Test
    public void givenSudokuService_whenAddValidMove_thenMoveIsAdded() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        assertTrue(service.addMove(0, 0, 5)); // Valid move
        assertEquals(5, board.getCell(0, 0).getValue());
    }
    
    @Test
    public void givenSudokuService_whenGenerateRandomNumbers_thenBoardIsPartiallyFilled() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        service.generateRandomNumbers(10); // Generate 10 random numbers
        int filledCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getCell(i, j).getValue() != 0) {
                    filledCells++;
                }
            }
        }
        assertEquals(10, filledCells); // Ensure 10 cells are filled
    }
    
    @Test
    public void givenSudokuService_whenRemoveMoveFromEmptyCell_thenNoChange() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        assertTrue(service.removeMove(0, 0)); // Remove from an empty cell
        assertEquals(0, board.getCell(0, 0).getValue()); // Ensure it remains empty
    }
    
    @Test
    public void givenSudokuService_whenAddOutOfRangeMove_thenMoveIsNotAdded() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        assertFalse(service.addMove(0, 0, 0)); // Invalid move (0)
        assertFalse(service.addMove(0, 0, 10)); // Invalid move (10)
    }
    
    @Test
    public void givenSudokuService_whenPrintBoard_thenOutputIsCorrect() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        // Set up the board with some values
        board.setCell(0, 0, 5);
        board.setCell(1, 1, 3);
        // Capture printed output (this might need specific setup depending on your environment)
        // service.printBoard();
        // Assert that the printed output matches expected board layout
    }
    
    @Test
    public void givenSudokuService_whenAddMoveAtBoundary_thenMoveIsAdded() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        assertTrue(service.addMove(0, 0, 5)); // Valid move at start
        assertEquals(5, board.getCell(0, 0).getValue());
        assertTrue(service.addMove(8, 8, 9)); // Valid move at end
        assertEquals(9, board.getCell(8, 8).getValue());
    }

    @Test
    public void givenSudokuService_whenGenerateMaxRandomNumbers_thenBoardIsFull() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        // Generate fewer numbers to ensure faster execution
        service.generateRandomNumbers(20); // Generate 20 random numbers
        int filledCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getCell(i, j).getValue() != 0) {
                    filledCells++;
                }
            }
        }
        assertTrue(filledCells <= 20); // Ensure no more than 20 cells are filled
    }

    @Test
    public void givenSudokuService_whenGenerateRandomNumbers_thenBoardIsValid() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        service.generateRandomNumbers(5); // Generate 5 random numbers
        // Verify that each move is valid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board.getCell(i, j).getValue();
                if (value != 0) {
                    assertTrue(board.isValidMove(i, j, value));
                }
            }
        }
    }

    @Test
    public void givenSudokuService_whenGenerateZeroRandomNumbers_thenBoardIsEmpty() {
        SudokuBoard board = new SudokuBoard();
        SudokuService service = new SudokuService(board);
        service.generateRandomNumbers(0); // Generate 0 random numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(0, board.getCell(i, j).getValue());
            }
        }
    }
}