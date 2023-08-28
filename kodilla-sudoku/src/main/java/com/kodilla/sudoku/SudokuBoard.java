package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rows;

    public List<SudokuRow> getRows() {
        return rows;
    }

    public void setRows(List<SudokuRow> rows) {
        this.rows = rows;
    }

    public SudokuBoard(){
        this.rows = new ArrayList<>();
        for (int i = 0 ; i < 9 ; i++){
            rows.add(new SudokuRow());
        }



    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (SudokuRow row : rows) {
            for (SudokuElement element : row.getElements()) {
                result.append(element.getValue() != SudokuElement.EMPTY ? element.getValue() : "|-|");
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
    public SudokuElement getElement(int row, int col) {
        SudokuRow sudokuRow = rows.get(row);
        return sudokuRow.getElements().get(col);
    }
    public boolean isValidMove(SudokuBoard board, int row, int col, int value) {
        SudokuElement element = board.getElement(row, col);

        for (int i = 0; i < 9; i++) {
            if (board.getElement(row, i).getValue() == value || board.getElement(i, col).getValue() == value) {
                return false;
            }
        }

        int sectionStartRow = row / 3 * 3;
        int sectionStartCol = col / 3 * 3;
        for (int i = sectionStartRow; i < sectionStartRow + 3; i++) {
            for (int j = sectionStartCol; j < sectionStartCol + 3; j++) {
                if (board.getElement(i, j).getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }


}
