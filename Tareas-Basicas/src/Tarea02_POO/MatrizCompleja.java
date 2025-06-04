package Tarea02_POO;

/**
 * Representa un número complejo con parte real e imaginaria.
 */
class NumeroComplejo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Accesores
    public double getParteReal()       { return parteReal; }
    public double getParteImaginaria(){ return parteImaginaria; }

    /**
     * Suma este complejo con otro y devuelve el resultado.
     */
    public NumeroComplejo sumar(NumeroComplejo otro) {
        return new NumeroComplejo(
            this.parteReal  + otro.parteReal,
            this.parteImaginaria + otro.parteImaginaria
        );
    }

    /**
     * Multiplica este complejo por otro según la fórmula:
     * (a+bi)*(c+di) = (ac - bd) + (ad + bc)i
     */
    public NumeroComplejo multiplicar(NumeroComplejo otro) {
        double real = this.parteReal * otro.parteReal
                      - this.parteImaginaria * otro.parteImaginaria;
        double imag = this.parteReal * otro.parteImaginaria
                      + this.parteImaginaria * otro.parteReal;
        return new NumeroComplejo(real, imag);
    }

    @Override
    public String toString() {
        return String.format("%.2f%+.2fi", parteReal, parteImaginaria);
    }
}

/**
 * Modela una matriz de números complejos y permite operaciones básicas
 * como suma, multiplicación e impresión.
 */
class MatrizCompleja {
    private int numeroFilas;
    private int numeroColumnas;
    private NumeroComplejo[][] celdas;

    public MatrizCompleja(int numeroFilas, int numeroColumnas) {
        this.numeroFilas    = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        this.celdas         = new NumeroComplejo[numeroFilas][numeroColumnas];

        // Inicializa cada celda en 0+0i
        for (int fila = 0; fila < numeroFilas; fila++) {
            for (int col = 0; col < numeroColumnas; col++) {
                celdas[fila][col] = new NumeroComplejo(0, 0);
            }
        }
    }

    // Obtiene el valor en (fila, columna)
    public NumeroComplejo obtener(int fila, int columna) {
        return celdas[fila][columna];
    }

    // Asigna un valor en (fila, columna)
    public void asignar(int fila, int columna, NumeroComplejo valor) {
        celdas[fila][columna] = valor;
    }

    /**
     * Suma elemento a elemento esta matriz con otra del mismo tamaño.
     */
    public MatrizCompleja sumar(MatrizCompleja otraMatriz) {
        MatrizCompleja resultado = new MatrizCompleja(numeroFilas, numeroColumnas);
        for (int fila = 0; fila < numeroFilas; fila++) {
            for (int col = 0; col < numeroColumnas; col++) {
                NumeroComplejo a = this.obtener(fila, col);
                NumeroComplejo b = otraMatriz.obtener(fila, col);
                resultado.asignar(fila, col, a.sumar(b));
            }
        }
        return resultado;
    }

    /**
     * Multiplica esta matriz por otra.
     * Usa un acumulador para sumar los productos de filas por columnas.
     */
    public MatrizCompleja multiplicar(MatrizCompleja otraMatriz) {
        MatrizCompleja producto = new MatrizCompleja(numeroFilas, otraMatriz.numeroColumnas);
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < otraMatriz.numeroColumnas; j++) {
                // Acumulador para la celda (i, j)
                NumeroComplejo acumulador = new NumeroComplejo(0, 0);
                for (int k = 0; k < numeroColumnas; k++) {
                    NumeroComplejo a = this.obtener(i, k);
                    NumeroComplejo b = otraMatriz.obtener(k, j);
                    acumulador = acumulador.sumar(a.multiplicar(b));
                }
                producto.asignar(i, j, acumulador);
            }
        }
        return producto;
    }

    /**
     * Imprime la matriz en consola, separando cada elemento con tabulador.
     */
    public void imprimir() {
        for (int fila = 0; fila < numeroFilas; fila++) {
            for (int col = 0; col < numeroColumnas; col++) {
                System.out.print(celdas[fila][col] + "\t");
            }
            System.out.println();
        }
    }
}
