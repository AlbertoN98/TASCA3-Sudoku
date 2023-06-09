package es.iesmz.ed.algoritmes;

/**
 * La clase Sudoku permite crear un objeto a partir de una matriz y también comprueba las filas, columnas y region.
 * Para que no haya numeros repetidos.
 * @Author Alberto Nieto
 * @Version: 09/06/2023
 */
public class Sudoku {
    private int[][] sudoku;

    /**
     * Constructor de la clase Sudoku.
     * @param matriz La matriz 9x9 que representa el sudoku.
     */

    public Sudoku(int[][] matriz) {
        sudoku = matriz;
    }
    /**
     * Verifica si el sudoku es correcto.
     * @return true si el sudoku es correcto, false en caso contrario.
     */
    public boolean esCorrecto() {
        for (int i = 0; i < 9; i++) {
            if (!comprobarFila(i) || !comprobarColumna(i) || !comprobarRegion(i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica si una fila del sudoku es correcta.
     * @param f El índice de la fila.
     * @return true si la fila es correcta, false en caso contrario.
     */
    private boolean comprobarFila(int f) {
        int[] test = new int[9];
        for (int c = 0; c < 9; c++) {
            if (test[sudoku[f][c] - 1] == 1) {
                return false;
            }
            test[sudoku[f][c] - 1] = 1;
        }
        return true;
    }
    /**
     * Verifica si una columna del sudoku es correcta.
     * @param c El índice de la columna.
     * @return true si la columna es correcta, false en caso contrario.
     */
    private boolean comprobarColumna(int c) {
        int[] test = new int[9];
        for (int f = 0; f < 9; f++) {
            if (test[sudoku[f][c] - 1] == 1) {
                return false;
            }
            test[sudoku[f][c] - 1] = 1;
        }
        return true;
    }
    /**
     * Verifica si una región del sudoku es correcta.
     * @param r El índice de la región.
     * @return true si la región es correcta, false en caso contrario.
     */
    private boolean comprobarRegion(int r) {
        int[] test = new int[9];
        int X = (r / 3) * 3;
        int Y = (r % 3) * 3;
        for (int i = X; i < X + 3; i++) {
            for (int j = Y; j < Y + 3; j++) {
                if (test[sudoku[i][j] - 1] == 1) {
                    return false;
                }
                test[sudoku[i][j] - 1] = 1;
            }
        }
        return true;
    }
}
