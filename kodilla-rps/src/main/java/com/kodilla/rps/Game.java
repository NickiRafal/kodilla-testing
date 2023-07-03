package com.kodilla.rps;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Player player;
    private static Computer computer;
    private int numberOfRounds;

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public Game() {
        player = new Player();
        computer = new Computer();
    }

    public void play() {
        System.out.println("Witaj w grze Kamień, Papier, Nożyce!");
        if (player.getName() == null) {
            player.askForName();
        }
        System.out.println("Cześć " + player.getName());

        askForNumberOfRounds();

        while (player.getWins() < numberOfRounds && computer.getWins() < numberOfRounds) {
            int playerChoice = player.makeMove();
            int computerChoice = computer.makeMove();

            System.out.println();
            System.out.println("Twój wybór: " + playerChoice);
            System.out.println("Wybór komputera: " + computerChoice);

            int result = checkRoundResult(playerChoice, computerChoice);
            displayRoundResult(result,playerChoice,computerChoice);
            updateGameResult(result);

            System.out.println();
            displayGameSummary();
        }

        char choice = askForEndOrNewGame();
        handleEndOrNewGame(choice);
    }

    private void askForNumberOfRounds() {
        System.out.print("Podaj liczbę wygranych rund do zakończenia gry: ");
        numberOfRounds = scanner.nextInt();
    }

    private int checkRoundResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0; // Remis
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == PAPER && computerChoice == ROCK) ||
                (playerChoice == SCISSORS && computerChoice == PAPER)) {
            return 1; // Wygrał gracz
        } else {
            return -1; // Wygrał komputer
        }
    }

    private void updateGameResult(int result) {
        if (result == 1) {
            player.incrementWins();
        } else if (result == -1) {
            computer.incrementWins();
        }
    }

    private static String interpretChoice(int choice) {
        switch (choice) {
            case ROCK:
                return "kamień";
            case PAPER:
                return "Papier";
            case SCISSORS:
                return "nożyce";
            default:
                return "nieznany";
        }
    }

    private static void displayRoundResult(int roundResult, int playerChoice, int computerChoice) {
        System.out.println("=== Wynik Rundy ===");
        System.out.println("Twój wybór: " + interpretChoice(playerChoice));
        System.out.println("Wybór komputera: " + interpretChoice(computerChoice));
        System.out.println("Twój wyknik: " + roundResult);
        System.out.println("Wynik gracza: " + player.getWins());
        System.out.println("Wynik komputera: " + computer.getWins());
    }

    private void displayGameSummary() {
        String winner;
        if (player.getWins() > computer.getWins()) {
            winner = player.getName();
        } else if (computer.getWins() > player.getWins()) {
            winner = "Komputer";
        } else {
            winner = "Remis";
        }

        System.out.println("=== Podsumowanie gry ===");
        System.out.println("Wynik gracza: " + player.getWins());
        System.out.println("Wynik komputera: " + computer.getWins());
        System.out.println("Wygrywa: " + winner);
    }

    private char askForEndOrNewGame() {
        System.out.println("Możesz zakończyć lub rozpocząć nową grę? (x - zakończ, n - nowa gra):");
        String choice = scanner.next().toLowerCase();

        while (!choice.equals("x") && !choice.equals("n")) {
            System.out.println("Nieprawidłowy wybór. Wpisz 'x' lub 'n':");
            choice = scanner.next().toLowerCase();
        }

        return choice.charAt(0);
    }

    private void handleEndOrNewGame(char choice) {
        if (choice == 'x') {
            System.out.println("Zakończono grę. Dziękujemy za udział!");
            scanner.close();
        } else if (choice == 'n') {
            player.resetWins();
            computer.resetWins();
            System.out.println( " nowa gra rozpoczęta.");
            play();
        }
    }
}
