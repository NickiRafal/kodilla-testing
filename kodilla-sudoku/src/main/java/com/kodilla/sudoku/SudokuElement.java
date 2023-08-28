package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>();
        for (int i = 1; i<=9 ; i++){
            possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }
}
