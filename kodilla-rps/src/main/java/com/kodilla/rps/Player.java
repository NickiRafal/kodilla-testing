package com.kodilla.rps;

import java.util.Scanner;

public class Player {
    private String name;
    private int wins;

    private static Scanner scanner = new Scanner(System.in);

    public Player() {
       // name = null;
        wins = 0;
    }

    public void askForName() {
        System.out.print("Podaj swoje imię: ");
        name = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public int makeMove() {
        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Twój wybór (1-3): ");
            String input = scanner.nextLine();

            if (input.equals("n") || input.equals("x")) {
                return input.charAt(0);
            } else {
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 3) {
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

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins++;
    }

    public void resetWins() {
        wins = 0;
    }
}
