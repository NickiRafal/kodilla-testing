package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private int wins = 0;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);



    public int makeMove() {

        return random.nextInt(3) + 1;
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
