package br.ufjf.dcc.dcc025.dcc025_sudoku;

import br.ufjf.dcc.dcc025.dcc025_sudoku.model.SudokuBoard;
import br.ufjf.dcc.dcc025.dcc025_sudoku.service.SudokuService;
import br.ufjf.dcc.dcc025.dcc025_sudoku.service.SudokuServiceInterface;
import br.ufjf.dcc.dcc025.dcc025_sudoku.ui.SudokuUI;

/**
 * The Main class serves as the entry point for the Sudoku application. It initializes
 * the necessary components and starts the user interface for interacting with the Sudoku game.
 * @author Vitória Isabela de Oliveira
 */
public class Main {

    /**
     * The main method is the entry point of the application. It sets the file encoding to UTF-8,
     * initializes the Sudoku board, service, and user interface, and starts the application.
     *
     * @param args command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        // Create a new Sudoku board
        SudokuBoard board = new SudokuBoard();

        // Initialize the Sudoku service with the board
        SudokuServiceInterface service = new SudokuService(board);

        // Create the user interface for the Sudoku game
        SudokuUI ui = new SudokuUI(service);

        // Start the user interface
        ui.start();
    }
}