package br.ufjf.dcc.dcc025.dcc025_sudoku.ui;

import br.ufjf.dcc.dcc025.dcc025_sudoku.service.SudokuServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.*;

public class SudokuUITest {

    private SudokuServiceInterface serviceMock;
    private SudokuUI sudokuUI;

    @BeforeEach
    public void setUp() throws UnsupportedEncodingException {
        serviceMock = Mockito.mock(SudokuServiceInterface.class);
    }

    private void provideInput(String data) throws UnsupportedEncodingException {
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);
        sudokuUI = new SudokuUI(serviceMock);
    }

    @Test
    public void givenManualGameOption_whenDefineManualGame_thenServiceAddMoveCalled() throws UnsupportedEncodingException {
        provideInput("2\n(2,3,4)\nsair\n");
        sudokuUI.start();
        verify(serviceMock, times(1)).addMove(1, 2, 4);
    }

    @Test
    public void givenInvalidInput_whenDefineManualGame_thenNoServiceMethodCalled() throws UnsupportedEncodingException {
        provideInput("2\n(10,10,10)\nsair\n");
        sudokuUI.start();
        verify(serviceMock, never()).addMove(anyInt(), anyInt(), anyInt());
    }

    @Test
    public void givenExitCommandLowercase_whenDefineManualGame_thenExit() throws UnsupportedEncodingException {
        provideInput("2\nsair\n");
        sudokuUI.start();
        // Exit command should be tested with caution as it will terminate the JVM.
    }

    @Test
    public void givenExitCommandUppercase_whenDefineManualGame_thenExit() throws UnsupportedEncodingException {
        provideInput("2\nSAIR\n");
        sudokuUI.start();
        // Exit command should be tested with caution as it will terminate the JVM.
    }
    
    @Test
    public void givenCompleteGame_whenPlay_thenGameCompletesSuccessfully() throws UnsupportedEncodingException {
        when(serviceMock.addMove(anyInt(), anyInt(), anyInt())).thenReturn(true);
        when(serviceMock.isGameComplete()).thenReturn(false).thenReturn(false).thenReturn(true);

        provideInput("2\n(1,1,5)\n(1,2,3)\n(1,3,4)\nsair\n");
        sudokuUI.start();
        verify(serviceMock, times(3)).addMove(anyInt(), anyInt(), anyInt());
        verify(serviceMock, times(1)).isGameComplete();
    }
    
    @Test
    public void givenExitCommand_whenStart_thenTerminatesGracefully() throws UnsupportedEncodingException {
        provideInput("3\n");
        sudokuUI.start();
        // Não deve chamar nenhum método adicional do serviço
        verify(serviceMock, never()).addMove(anyInt(), anyInt(), anyInt());
        verify(serviceMock, never()).generateRandomNumbers(anyInt());
    }
}