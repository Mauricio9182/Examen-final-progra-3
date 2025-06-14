package com.beesion.ms.logic.sudoku;

public class SudokuBoard {
    private final String[][] board;

    public SudokuBoard(String[][] board) {
        this.board = board;
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return board.length;
    }
}
