package com.kodilla.rps;
import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private static final int WINNING_ROUNDS = 3;

    private static String playerName;
    private static int numberOfWonRounds;

    private static int playerWins = 0;
    private static int computerWins = 0;
    private static int draws = 0;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        System.out.println("Witaj w grze Kamień, Papier, Nożyce!");

        if (playerName == null) {
            askForPlayerName();
            System.out.println("Cześć, " + playerName);
        }
        askForNumberOfWonRounds();
        displayInformation();

        while (playerWins < numberOfWonRounds && computerWins < numberOfWonRounds) {
            int playerChoice = getPlayerChoice();
            int computerChoice = getRandomComputerChoice();

            System.out.println();
            System.out.println("Twój wybór " + interpretChoice(playerChoice));
            System.out.println("Wybór komputera: " + interpretChoice(computerChoice));

            int roundResult = checkRoundResult(playerChoice, computerChoice);
            displayRoundResult(roundResult);
            updateGameResult(roundResult);

            System.out.println();
            gameSummary();
        }

        char choice = askForEndOrNewGame();
        handleEndOrNewGameChoice(choice);
    }

    private static void askForPlayerName() {
        System.out.print("Podaj swoje imię: ");
        playerName = scanner.nextLine();
    }

    private static void askForNumberOfWonRounds() {
        System.out.print("Podaj liczbę wygranych rund do zakończenia gry: ");
        numberOfWonRounds = scanner.nextInt();
    }

    private static void displayInformation() {
        System.out.println();
        System.out.println("Klawisze do obsługi gry:");
        System.out.println("1 - zagranie \"kamień\"");
        System.out.println("2 - zagranie \"papier\"");
        System.out.println("3 - zagranie \"nożyce\"");
        System.out.println("x - zakończenie gry");
        System.out.println("n - rozpoczęcie nowej gry");
        System.out.println();
    }

    private static int getPlayerChoice() {
        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Twój wybór (1-3): ");
            String input = scanner.next();

            if (input.equals("n") || input.equals("x")) {
                return input.charAt(0);
            } else {
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= ROCK && choice <= SCISSORS) {
                        validChoice = true;
                    } else {
                        System.out.println("Nieprawidłowy wybór. Wybierz liczbę od 1 do 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nieprawidłowy wybór. Wybierz liczbę od 1 do 3.");
                }
            }
        }

        return choice;
    }

    private static int getRandomComputerChoice() {
        return random.nextInt(SCISSORS) + 1;
    }

    private static char askForEndOrNewGame() {
        System.out.println("Możesz zakończyć lub rozpocząć nową grę? (x - zakończ, n - nowa gra):");
        String choice = scanner.next().toLowerCase();

        while (!choice.equals("x") && !choice.equals("n")) {
            System.out.println("Nieprawidłowy wybór. Wpisz 'x' lub 'n':");
            choice = scanner.next().toLowerCase();
        }

        return choice.charAt(0);
    }

    private static void handleEndOrNewGameChoice(char choice) {
        if (choice == 'x') {
            System.out.println("Zakończono grę. Dziękujemy za udział!");
        } else if (choice == 'n') {
            playerWins = 0;
            computerWins = 0;
            draws = 0;
            System.out.println(playerName +" Nowa gra rozpoczęta.");
            play();
        }
    }

    private static void gameSummary() {
        String winner;
        if (playerWins > computerWins) {
            winner = "Gracz";
        } else if (computerWins > playerWins) {
            winner = "Komputer";
        } else {
            winner = "Remis";
        }

        System.out.println("=== Podsumowanie gry ===");
        System.out.println("Wynik gracza: " + playerWins);
        System.out.println("Wynik komputera: " + computerWins);
        System.out.println("Remisy: " + draws);
        System.out.println("Wygrał: " + winner);
    }

    private static void displayRoundResult(int roundResult) {
        System.out.println("=== Wynik rundy ===");
        System.out.println("Twój wynik: " + roundResult);
        System.out.println("Wynik gracza: " + playerWins);
        System.out.println("Wynik komputera:  " + computerWins);
    }

    private static String interpretChoice(int choice) {
        switch (choice) {
            case ROCK:
                return "Kamień";
            case PAPER:
                return "Papier";
            case SCISSORS:
                return "Nożyce";
            default:
                return "nieznany";
        }
    }

    private static int checkRoundResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == PAPER && computerChoice == ROCK) ||
                (playerChoice == SCISSORS && computerChoice == PAPER)) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void updateGameResult(int roundResult) {
        if (roundResult == 1) {
            playerWins++;
        } else if (roundResult == -1) {
            computerWins++;
        } else {
            draws++;
        }
    }
}
