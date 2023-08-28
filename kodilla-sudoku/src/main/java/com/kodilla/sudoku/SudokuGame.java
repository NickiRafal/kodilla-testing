package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;
    public SudokuGame(){
        this.board = new SudokuBoard();
        this.scanner = new Scanner(System.in);
    }
    int numberOfSolutions = 5;
    boolean firstDisplayBoard = false;
    public boolean resolveSudoku() {

        try {
            if (!firstDisplayBoard) {
                System.out.println("Pusta tablica Sudoku ");
                System.out.println(board);
                firstDisplayBoard = true;
            }
            if(numberOfSolutions >0) {

                System.out.println("Czy chcesz kontynuować rozwiązywanie Sudoku? (tak / nie)" +
                        " pozostało " +numberOfSolutions + " prób");

            }else {
                System.out.println("Koniec gry");
                return true;
            }
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("tak")) {
                if (solveSudoku(board)) {
                    System.out.println("Rozwiązanie Sudoku:");
                    System.out.println(board);
                    numberOfSolutions -= 1;
                } else {
                    System.out.println("Nie udało się rozwiązać Sudoku.");
                }
                return false;
            } else if (userInput.equalsIgnoreCase("nie")){

                return true;
            }else {
                System.out.println("Możesz wpisać tak lub nie");
                return false;
            }
        }catch (Exception e){
            System.out.println("Wystąpił błąd : " + e.getMessage());
            e.printStackTrace();
            return true;
        }
    }
    public boolean solveSudoku(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getElement(row, col).getValue() == SudokuElement.EMPTY) {
                    for (int num = 1; num <= 9; num++) {
                        if (board.isValidMove(board, row, col, num)) {
                            board.getElement(row, col).setValue(num);

                            if (solveSudoku(board)) {
                                return true;
                            }
                            board.getElement(row, col).setValue(SudokuElement.EMPTY);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuGame sudokuGame = new  SudokuGame();
        while (!gameFinished){

            gameFinished = sudokuGame.resolveSudoku();
        }
    }
}
