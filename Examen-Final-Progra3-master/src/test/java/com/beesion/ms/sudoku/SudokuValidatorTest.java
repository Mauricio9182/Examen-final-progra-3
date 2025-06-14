package com.beesion.ms.sudoku;

import com.beesion.ms.logic.sudoku.SudokuBoard;
import com.beesion.ms.logic.sudoku.SudokuValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuValidatorTest {

    @Test
    void testSudokuValido() {
        String[][] tableroValido = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        SudokuBoard board = new SudokuBoard(tableroValido);
        SudokuValidator validator = new SudokuValidator();
        assertTrue(validator.isValid(board), "El tablero válido debería retornar true.");
    }

    @Test
    void testSudokuInvalidoPorFila() {
        String[][] tableroInvalido = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "5"}, // ← duplicado de "5"
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        SudokuBoard board = new SudokuBoard(tableroInvalido);
        SudokuValidator validator = new SudokuValidator();
        assertFalse(validator.isValid(board), "El tablero con fila inválida debería retornar false.");
    }
}
