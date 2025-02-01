package br.ufjf.dcc.dcc025.dcc025_sudoku.model;

/**
 * The SudokuCell class represents a single cell in a Sudoku board.
 * It stores the row and column indices of the cell, as well as its current value.
 *  @author Vitória Isabela de Oliveira
 */
public class SudokuCell {
    private int row;
    private int col;
    private int value;

    /**
     * Constructs a SudokuCell with specified row, column, and initial value.
     *
     * @param row the row index of the cell (0-based index).
     * @param col the column index of the cell (0-based index).
     * @param value the initial value of the cell.
     */
    public SudokuCell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    /**
     * Retrieves the row index of the cell.
     *
     * @return the row index (0-based index).
     */
    public int getRow() {
        return row;
    }

    /**
     * Retrieves the column index of the cell.
     *
     * @return the column index (0-based index).
     */
    public int getCol() {
        return col;
    }

    /**
     * Retrieves the current value of the cell.
     *
     * @return the value of the cell.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the cell.
     *
     * @param value the new value to be set in the cell.
     */
    public void setValue(int value) {
        this.value = value;
    }
}