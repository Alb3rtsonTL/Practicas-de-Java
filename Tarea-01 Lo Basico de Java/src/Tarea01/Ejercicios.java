//* Package donde se encuentran los archivos del proyecto
package Tarea01;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/** Esta es la clase en donde se encuentran los 22 ejercicios, cada uno en un método aparte desglosado. */
public class Ejercicios {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 1.Declarar variable de los diferentes tipos, asignarles valor e imprimir el valor.
     */
    public static void Ejercicio_01() {
        System.out.println("Ejercicio 1\n");

        // Diferentes tipos de variables
        int enteroEdad = 20;
        double dobleTemperatura = 3.14;
        char charLetra = 'A';
        boolean booleano = true;
        String mensaje = "Este fue el primer ejercicio\n";

        // MMuestro los valores de las variables
        System.out.println("Entero: " + enteroEdad);
        System.out.println("Flotante doble: " + dobleTemperatura);
        System.out.println("Carácter: " + charLetra);
        System.out.println("Booleano: " + booleano);
        System.out.println("Texto: " + mensaje);
        System.out.println();
    }

    /** 2.Buscar cómo se declara una constante en java e imprimir el valor.
     * Probar de cambiar su valor luego y ver que es lo que pasa. */
    public static void Ejercicio_02() {
        System.out.println("Ejercicio 2\n");

        // Creo la variable constante
        final String variableConstante = "100 Carros";

        // Muestro su valor
        System.out.println("Constante = " + variableConstante);
        System.out.println();
    }

    /**
     * 3.Declara un entero, incrementarlo, decrementarlo, hacer operaciones con el.
     */
    public static void Ejercicio_03() {
        System.out.println("Ejercicio 3\n");
        // Inicio el valor de la variable
        int numeroX = 16;
        System.out.println("El numero ahora es: " + numeroX);
        // Incremento el valor de la variable
        numeroX++;
        System.out.println("Incremento: " + numeroX);
        // Decremento el valor de la variable
        numeroX--;
        System.out.println("Decremento: " + numeroX);
        // Hago las operaciones
        int sumar = numeroX + 19;
        int restar = numeroX - 6;
        int dividir = numeroX / 2;
        int multiplicar = numeroX * 8;

        // Muestro los resultados finales
        System.out.println("\nNumero: " + numeroX);
        System.out.println();
        System.out.println("Suma: (" + numeroX + " + 19 = " + sumar + ")");
        System.out.println("Resta: (" + numeroX + " - 6 = " + restar + ")");
        System.out.println("División (" + numeroX + " / 2 = " + dividir + ")");
        System.out.printf("Multiplicación (" + numeroX + " x 8 = " + multiplicar + ")");
        System.out.println();
    }

    /**
     * 4.Declarar un float con valor = 10152466.25. Declarar un byte que es igual a 5 + el float.
     */
    public static void Ejercicio_04() {
        System.out.println("Ejercicio 4\n");

        // Creo la variable de tipo flotante
        float valorFloat = 10152466.25f;

        // Sumo el flotante al entero y luego asigno a byte
        byte resultado = (byte) (5 + valorFloat);

        // Muestro los resultados
        System.out.println("Decimal: " + valorFloat);
        System.out.println("Byte (5 + flotante): " + resultado);
        System.out.println();
    }

    /**
     * 5.Adjuntar comentario de una y de varias líneas en su código. Imprimir la fecha y hora del sistema.
     */
    public static void Ejercicio_05() {
        System.out.println("Ejercicio 5\n");

        // Aquí tomo la fecha y hora actuales usando la clase LocalDateTime y su método
        // now()
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Indico cual sera el formato que usare
        DateTimeFormatter formatoFeHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Muestro la fecha y hora con el formato aplicado
        System.out.println("Fecha y hora actuales: " + fechaHoraActual.format(formatoFeHora));

        /*
         * En C# si se deja un Console.WriteLine(); sin nada escrito hace un salto de
         * linea por eso probe con System.out.println(); y funciona igual
         */
        System.out.println();
    }

    /**
     * 6.Declarar un entero y asignarle un valor. Si el valor < 5 imprimir "Pequeño", si no imprimir "Grande".
     */
    public static void Ejercicio_06() {
        System.out.println("Ejercicio 6a");
        System.out.print("Introduce un entero: ");
        /** Uso scanner.nextInt() para tomar el input del usuario desde el teclado */
        int primerNumero = scanner.nextInt();

        // Si el primer numero o primerNumero es menor a 5
        if (primerNumero < 5) {
            System.out.println("Pequeño");
        } else {
            System.out.println("Grande");
        }

        System.out.println("\nEjercicio 6b");
        System.out.print("Introduce otro entero: ");
        // Vuelvo a usar scanner.nextInt() y guardo el input en la variable entera nu2
        int segundoNumero = scanner.nextInt();

        // Si el segundo numero es 1, 2, o 3
        if (segundoNumero == 1) {
            System.out.println("Uno"); // En el mandato en word sale "no"
        } else if (segundoNumero == 2) {
            System.out.println("Dos");
        } else if (segundoNumero == 3) {
            System.out.println("3"); // Pense ponerlo en texto, pero mejor no
        } else {
            /** En caso de que no sea ninguna de las tres */
            System.out.println("Ni uno, ni dos, ni tres");
        }
        System.out.println();
    }

    /**
     * 7.Declarar un entero = 0. Mientras el entero <5, imprimir su valor y incrementarlo de 1.
     */
    public static void Ejercicio_07() {
        System.out.println("Ejercicio 7\n");
        int numeroX = 0;

        // Incrementar numeroX hasta que llegue al valor de 5
        while (numeroX < 5) {
            System.out.println("Valor: " + numeroX);
            numeroX++;
        }
        System.out.println();
    }

    /**
     * 8.Declarar un entero = 10. Mientras el entero >5, imprimir su valor y decrementarlo de 1,
     * pero imprime por lo menos una vez su valor.
     */
    public static void Ejercicio_08() {
        System.out.println("Ejercicio 8\n");
        int numeroX = 10;

        // Hace el decremento del valor hasta llegar a 5
        do {
            System.out.println("Valor: " + numeroX);
            numeroX--;
        } while (numeroX > 5);

        System.out.println();
    }

    /**
     * 9.Crear un bucle que se ejecuta 10 veces utilizando un entero que va de 10 a19
     * incrementándose en 1. Imprimir en cada bucle el valor del entero, menos cuando es igual a 15.
     */
    public static void Ejercicio_09() {
        System.out.println("Ejercicio 9\n");

        // Inicia el contador en 10 y se ejecuta mientras sea menor o igual a 19,
        for (int contador = 10; contador <= 19; contador++) {
            // Si el contador vale 15, salta o imprime ese valor
            if (contador == 15)
                continue;
            System.out.println("Valor = " + contador);
        }
        System.out.println();
    }

    /** 10.Pedir dos números y decir si son iguales o no */
    public static void Ejercicio_10() {
        System.out.println("Ejercicio 10\n");
        System.out.print("Número 1: ");
        int primerNumero = scanner.nextInt();
        System.out.print("Número 2: ");
        int segundoNumero = scanner.nextInt();

        // Si el valor de ambos números es igual
        if (primerNumero == segundoNumero) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
        System.out.println();
    }

    /**
     * 11. Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien usando un switch.
     */
    public static void Ejercicio_11() {
        System.out.println("Ejercicio 11\n");
        System.out.print("Introduce una nota del 0 al 10: ");
        int notaUsuario = scanner.nextInt();

        // Según la nota correspondiente muestro la indicación
        switch (notaUsuario) {
            case 0, 1, 2, 3, 4:
                System.out.println("Insuficiente");
                break;
            case 5, 6:
                System.out.println("Suficiente");
                break;
            case 7, 8, 9, 10:
                System.out.println("Bien");
                break;
            default:
                System.out.println("Nota fuera de rango");
        }
        System.out.println();
    }

    /**
     * 12. Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un numero negativo.
     */
    public static void Ejercicio_12() {
        System.out.println("Ejercicio 12\n");
        int numeroX;
        // Aquí se pedirá un numero para calcular su cuadrado mientras numeroX >= 0
        do {
            System.out.print("Introduzca un número negativo para salir (-1): ");
            numeroX = scanner.nextInt();
            if (numeroX >= 0) {
                System.out.println("Cuadrado de " + numeroX + ": " + (numeroX * numeroX));
            }
        } while (numeroX >= 0);

        System.out.println();
    }

    /**
     * 13.Pedir números hasta que se teclee un 0, mostrar la suma de todos los números introducidos.
     * Usando solo uno de los bucles mostrados en clase.
     */
    public static void Ejercicio_13() {
        System.out.println("Ejercicio 13\n");
        int suma = 0, x;
        // Este bucle muestra la suma de los numero que se introducen hasta que se sale
        // con un 0
        do {
            System.out.print("Teclea un número (0 para terminar): ");
            x = scanner.nextInt();
            suma += x;
        } while (x != 0);
        System.out.println("Suma total: " + suma);
        System.out.println();
    }

    /**
     * 14.Pedir 15 números y escribir la suma total. Usando solo uno de los bucles mostrados en clase.
     */
    public static void Ejercicio_14() {
        System.out.println("Ejercicio 14\n");
        int suma = 0;
        for (int contador = 1; contador <= 15; contador++) {
            System.out.print("Número " + contador + ": ");
            suma += scanner.nextInt();
        }
        System.out.println("Suma de los 15 números: " + suma);

        System.out.println();
    }

    /**
     * 15.Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número.
     */
    public static void Ejercicio_15() {
        System.out.println("Ejercicio 15\n");
        System.out.print("Introduce un número del 0 al 10: ");
        int numeroX = scanner.nextInt();
        System.out.println("Tabla de multiplicar de " + numeroX);

        // Aplico un for para que cuente y hacer que multiplique
        for (int contador = 0; contador <= 10; contador++) {
            System.out.printf("%d x %d = %d%n", numeroX, contador, numeroX * contador);
        }
        System.out.println();
    }

    /**
     * 16.Determinar a cuánto es igual la suma de los elementos de la serie de Fibonacci entre 0 y 100.
     */
    public static void Ejercicio_16() {
        System.out.println("Ejercicio 16\n");

        int numeroAnterior = 0;
        int numeroActual = 1;
        int sumaDeFibonacci = 0;

        // Calcula y suma los números de Fibonacci menores o iguales a 100
        while (numeroAnterior <= 100) {
            sumaDeFibonacci += numeroAnterior;

            int siguienteNumero = numeroAnterior + numeroActual;
            numeroAnterior = numeroActual;
            numeroActual = siguienteNumero;
        }
        System.out.println("Suma de los Números Fibonacci del 0 al 100: " + sumaDeFibonacci);
        System.out.println();
    }

    /**
     * 17. Determinar a cuánto es igual el promedio entero
     * de los elementos de la serie de Fibonacci entre 0 y 1000.
     */
    public static void Ejercicio_17() {
        System.out.println("Ejercicio 17\n");
        int numeroAnterior = 0, numeroActual = 1, sumaT = 0, cantidad = 0;

        // Calculo el promedio de la serie Fibonacci
        while (numeroAnterior <= 1000) {
            sumaT += numeroAnterior;
            cantidad++;

            int siguiente = numeroAnterior + numeroActual;
            numeroAnterior = numeroActual;
            numeroAnterior = siguiente;
        }
        int promedio = sumaT / cantidad;
        System.out.println("Promedio de los Números Fibonacci del 0 al 1000: " + promedio);
        System.out.println();
    }

    /**
     * 18.Determinar cuántos elementos de la serie de Fibonacci se encuentran entre 1000 y 2000.
     */
    public static void Ejercicio_18() {
        System.out.println("Ejercicio 18\n");
        int numeroAnterior = 0, numeroActual = 1, cantidadEnRango = 0;

        // Genera números Fibonacci hasta que superen 2000
        while (numeroAnterior <= 2000) {
            // Cuenta los que están en el rango [1000, 2000]
            if (numeroAnterior >= 1000)
                cantidadEnRango++;

            int siguienteNumeroFibonacci = numeroAnterior + numeroActual;
            numeroAnterior = numeroActual;
            numeroActual = siguienteNumeroFibonacci;
        }
        System.out.println("Cantidad de Números Fibonacci entre 1000 y 2000: " + cantidadEnRango);
        System.out.println();
    }

    /** 19.Leer un número y calcularle su factorial. */
    public static void Ejercicio_19() {
        System.out.println("Ejercicio 19\n");
        System.out.print("Introduce un número: ");
        // * Probe con 500,000
        int numeroX = scanner.nextInt();

        /**
         * ! Aquí es necesario usar algo como el BigInteger de C#
         * System.Numerics.BigInteger;
         * Casualmente se llama igual en Java, esto es para que cuando pruebe con un
         * numero grande funcione con un limite de capacidad mas grande que el de un
         * entero normal sin dar error.
         */
        BigInteger factorialGrande = BigInteger.ONE;

        // Toma el numeroX ingresado por el usuario y calcula el factorial
        for (int contador = 2; contador <= numeroX; contador++) {
            factorialGrande = factorialGrande.multiply(BigInteger.valueOf(contador));
        }
        System.out.println(numeroX + "! = " + factorialGrande);
        System.out.println();
    }

    /**
     * 20.Leer un número y calcularles la factorial a todos los enteros comprendidos entre 1 y el número leído.
     ** Reutilice mi código anterior y le quite algunos comentarios
     */
    public static void Ejercicio_20() {
        System.out.println("Ejercicio 20\n");
        System.out.print("Introduce un número: ");
        int numeroX = scanner.nextInt();
        System.out.println("Estos son los factoriales entre 1 y el número " + numeroX);

        /**
         * Toma el numeroX ingresado por el usuario y inicia un contador para
         * calcula el factorial de los enteros comprendidos entre 1 y numeroX.
         */
        for (int contador1 = 1; contador1 <= numeroX; contador1++) {
            // Uso BigInteger para manejar números enteros mas grandes
            BigInteger factorialGrande = BigInteger.ONE;

            // El mismo código de antes pero usando el contador1 inicial para establecer el
            for (int contador2 = 2; contador2 <= contador1; contador2++) {
                factorialGrande = factorialGrande.multiply(BigInteger.valueOf(contador2));
            }
            System.out.println(contador1 + "! = " + factorialGrande);
        }
        System.out.println();
    }

    /**
     * 21. Leer un número entero y calcular el promedio entero de las
     * factoriales de los enteros comprendidos entre 1 y el número leído.
     */
    public static void Ejercicio_21() {
        System.out.println("Ejercicio 21\n");
        System.out.print("Introduce un número: ");
        int numeroX = scanner.nextInt();

        // Uso BigInteger para manejar números enteros mas grandes
        BigInteger factorialSuma = BigInteger.ZERO;

        // For para calcular la suma de los factoriales de 1 a numeroX
        for (int contador1 = 1; contador1 <= numeroX; contador1++) {
            // El mismo BigInteger de antes
            BigInteger factorialGrande = BigInteger.ONE;

            // Calculo contador1!
            for (int contador2 = 2; contador2 <= contador1; contador2++) {
                factorialGrande = factorialGrande.multiply(BigInteger.valueOf(contador2));
            }
            // Sumo el factorial al acumulador
            factorialSuma = factorialSuma.add(factorialGrande);
        }
        // Calculo el promedio entero dividiendo la suma entre numeroX
        BigInteger factorialPromedio = factorialSuma.divide(BigInteger.valueOf(numeroX));

        // Muestro el promedio entero
        System.out.println("Promedio entero de factoriales: " + factorialPromedio);
        System.out.println();
    }

    /**
     * 22.Leer un número entero y calcular a cuánto es igual la sumatoria de todas
     * las factoriales de los números comprendidos entre 1 y el número leído
     */
    public static void Ejercicio_22() {
        System.out.println("Ejercicio 22\n");
        System.out.print("Introduce un número: ");
        int numeroX = scanner.nextInt();

        // Uso BigInteger para manejar números enteros mas grandes
        BigInteger factorialSuma = BigInteger.ZERO;

        // For para calcular la suma de los factoriales de 1 a numeroX
        for (int contador1 = 1; contador1 <= numeroX; contador1++) {
            // El mismo BigInteger de antes
            BigInteger factorialGrande = BigInteger.ONE;

            // Calcular contador1!
            for (int contador2 = 2; contador2 <= contador1; contador2++) {
                factorialGrande = factorialGrande.multiply(BigInteger.valueOf(contador2));
            }
            // Acumulo el factorial en la suma
            factorialSuma = factorialSuma.add(factorialGrande);
        }
        // Muestro el resultado de la sumatoria
        System.out.println("Sumatoria de los factoriales: " + factorialSuma);
        System.out.println();
    }
}
