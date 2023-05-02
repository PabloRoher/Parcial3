package Barcos;

public class Tablero {
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean estaDentroDelTablero(int fila, int columna) {
        return fila >= 0 && fila <= filas && columna >= 0 && columna <= columnas;
    }
}

