package br.ufjf.dcc.dcc025.dcc025_sudoku.ui;

import br.ufjf.dcc.dcc025.dcc025_sudoku.service.SudokuServiceInterface;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuUI {
    private SudokuServiceInterface service;
    private Scanner scanner;
    private boolean running = true; // Variável de controle

    public SudokuUI(SudokuServiceInterface service) {
        this.service = service;
        this.scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    }

    public void start() {
        while (running) {
            System.out.println("Bem-vindo ao Sudoku!");
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Gerar jogo aleatorio");
            System.out.println("2. Definir jogo manualmente");
            System.out.println("3. Sair");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (option) {
                case 1:
                    generateRandomGame();
                    play();
                    break;
                case 2:
                    defineManualGame();
                    play();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    running = false; // Encerra o loop
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    private void generateRandomGame() {
        System.out.println("Quantos numeros deseja sortear? (Recomendado: 20-30)");
        int count = scanner.nextInt();
        scanner.nextLine();

        service.generateRandomNumbers(count);
        System.out.println("Jogo gerado com sucesso!");
        service.printBoard();
    }

    private void defineManualGame() {
        System.out.println("Digite os valores iniciais no formato (linha,coluna,valor).");
        System.out.println("Exemplo: (2,5,3)(2,6,4)(2,9,1)");
        System.out.println("Digite 'sair' para encerrar o jogo.");

        while (running) {
            System.out.print("Entrada: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado pelo usuario.");
                running = false; // Set running to false to exit the entire application
                return; // Return from the method
            }

            // Processar multiplas entradas
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(input);

            boolean validInput = false;
            while (matcher.find()) {
                int row = Integer.parseInt(matcher.group(1)) - 1; // Ajustar para indice 0
                int col = Integer.parseInt(matcher.group(2)) - 1; // Ajustar para indice 0
                int value = Integer.parseInt(matcher.group(3));

                if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
                    if (service.addMove(row, col, value)) {
                        System.out.println("Valor adicionado: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                        validInput = true;
                    } else {
                        System.out.println("Valor invalido ou posicao ja preenchida: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                    }
                } else {
                    System.out.println("Entrada fora do dominio: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                }
            }

            if (!validInput) {
                System.out.println("Nenhuma entrada valida foi processada. Tente novamente.");
            }

            service.printBoard();
        }
    }

    private void play() {
        while (!service.isGameComplete() && running) {
            System.out.println("Digite sua jogada no formato (linha,coluna,valor) ou 'sair' para encerrar o jogo:");
            System.out.println("Exemplo: (2,5,3)(2,6,4)(2,9,1)");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado pelo usuario.");
                return; // Retorna do método
            }

            // Processar multiplas entradas
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(input);

            boolean validInput = false;
            while (matcher.find()) {
                int row = Integer.parseInt(matcher.group(1)) - 1; // Ajustar para indice 0
                int col = Integer.parseInt(matcher.group(2)) - 1; // Ajustar para indice 0
                int value = Integer.parseInt(matcher.group(3));

                if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
                    if (service.addMove(row, col, value)) {
                        System.out.println("Jogada adicionada: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                        validInput = true;
                    } else {
                        System.out.println("Jogada invalida: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                    }
                } else {
                    System.out.println("Entrada fora do dominio: (" + (row + 1) + "," + (col + 1) + "," + value + ")");
                }
            }

            if (!validInput) {
                System.out.println("Nenhuma jogada valida foi processada. Tente novamente.");
            }

            service.printBoard();
        }

        if (running) {
            System.out.println("Parabens! Voce completou o Sudoku!");
        }
    }
}