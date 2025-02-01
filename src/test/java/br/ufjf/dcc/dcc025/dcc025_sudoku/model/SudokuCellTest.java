package br.ufjf.dcc.dcc025.dcc025_sudoku.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuCellTest {
    @Test
    public void givenNewSudokuCell_whenGetRow_thenReturnCorrectRow() {
        SudokuCell cell = new SudokuCell(1, 2, 3);
        assertEquals(1, cell.getRow());
    }

    @Test
    public void givenNewSudokuCell_whenGetCol_thenReturnCorrectCol() {
        SudokuCell cell = new SudokuCell(1, 2, 3);
        assertEquals(2, cell.getCol());
    }

    @Test
    public void givenNewSudokuCell_whenGetValue_thenReturnCorrectValue() {
        SudokuCell cell = new SudokuCell(1, 2, 3);
        assertEquals(3, cell.getValue());
    }

    @Test
    public void givenSudokuCell_whenSetValue_thenValueIsUpdated() {
        SudokuCell cell = new SudokuCell(1, 2, 3);
        cell.setValue(5);
        assertEquals(5, cell.getValue());
    }
}