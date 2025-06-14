package com.beesion.ms.logic.sudoku;

import java.util.HashSet;

public class SudokuValidator {

    public boolean isValid(SudokuBoard board) {
        for (int i = 0; i < 9; i++) {
            HashSet<String> fila = new HashSet<>();
            HashSet<String> columna = new HashSet<>();
            HashSet<String> bloque = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                String valFila = board.getCell(i, j);
                if (!valFila.equals(".") && !fila.add(valFila)) return false;

                String valCol = board.getCell(j, i);
                if (!valCol.equals(".") && !columna.add(valCol)) return false;

                int row = 3 * (i / 3) + j / 3;
                int col = 3 * (i % 3) + j % 3;
                String valBloque = board.getCell(row, col);
                if (!valBloque.equals(".") && !bloque.add(valBloque)) return false;
            }
        }
        return true;
    }
}
