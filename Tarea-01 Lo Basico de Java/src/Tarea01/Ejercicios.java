package Tarea01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicios {
    
    private static final Scanner scanner = new Scanner(System.in);

    /** 1.Declarar variable de los diferentes tipos, asignarles valor e imprimir el valor. */
    public static void Ejercicio_01() {
        System.out.println("Ejercicio 1\n");

        // Diferentes tipos de variables
        int entero_edad = 20;
        double doble_temperatura = 3.14;
        char caracter_letra = 'A';
        boolean booleano_verdadero = true;
        String texto_mensaje = "Este fue el primer ejercicio\n";

        // MMuestro los valores de las variables
        System.out.println("Entero: " + entero_edad);
        System.out.println("Flotante doble: " + doble_temperatura);
        System.out.println("Caracter: " + caracter_letra);
        System.out.println("Buleano: " + booleano_verdadero);
        System.out.println("Texto: " + texto_mensaje);
        System.out.println();
    }

    /** 2.Buscar cómo se declara una constante en java e imprimir el valor. Probar de cambiar su valor luego y ver que es lo que pasa. */
    public static void Ejercicio_02() {
        System.out.println("Ejercicio 2\n");

        // Creo la variable constante
        final String variableConstante = "100 Carros";
        
        // Muestro su valor
        System.out.println("Constante = " + variableConstante);
        System.out.println();
    }

    /** 3.Declara un entero, incrementarlo, decrementarlo, hacer operaciones con el. */
    public static void Ejercicio_03()
    {
        System.out.println("Ejercicio 3\n");

        // Inicio el valor de la variable
        int numeroX = 16;
        System.out.println("El numero ahora es: "+ numeroX);
        
        // Incremento el valor de la variable
        numeroX++;
        System.out.println("Incremento: "+ numeroX);
        
        // Decremento el valor de la variable
        numeroX--;
        System.out.println("Decremento: "+ numeroX);

        // Hago las operaciones
        int suma = numeroX + 5;
        int producto = numeroX * 2;
        
        // Muestro los resultados finales
        System.out.println("Numero: " + numeroX);
        System.out.println("Suma: " + suma);
        System.out.println("Producto: " + producto);
        System.out.println();
    }
    
    /** 4.Declarar un float con valor = 10152466.25. Declarar un byte que es igual a 5 + el float. */    
    public static void Ejercicio_04()
    {
        System.out.println("Ejercicio 4\n");
        
        // Creo la variable de tipo flotante
        float valorFloat = 10152466.25f;
        
        // Sumo el flotante al entero y luego asigno a byte
        byte resultado = (byte)(5 + valorFloat);
        
        // Muestro los resultados
        System.out.println("Decimal: " + valorFloat);
        System.out.println("Byte (5 + flotante): " + resultado);
        System.out.println(); 
    }

    /** 5.Adjuntar comentario de una y de varias líneas en su código. Imprimir la fecha y hora del sistema. */
    public static void Ejercicio_05(){
        System.out.println("Ejercicio 5\n");

        // Aqui tomo la fecha y hora actuales usando la clase LocalDateTime y su metodo now()
        LocalDateTime fechaHora_actual = LocalDateTime.now();
        
        // Indico cual sera el formato que usare
        DateTimeFormatter formato_FH = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Muestro la fecha y hora con el formato aplicado
        System.out.println("Fecha y hora actuales: " + fechaHora_actual.format(formato_FH));
        
        /* En C# si se deja un Console.WriteLine(); sin nada escrito hace un salto de linea
         * por eso probe con System.out.println(); y funciona igual
         */
        System.out.println();
    }

    /** 6.Declarar un entero y asignarle un valor. Si el valor < 5 imprimir "Pequeño", si no imprimir "Grande". */
    public static void Ejercicio_06(){
        System.out.println("Ejercicio 6a");
        System.out.print("Introduce un entero: ");

        /** Uso scaner.nextInt() para tomar el input del usuario desde el teclado */
        int n1 = scanner.nextInt();
        
        // Si el primer numero o n1 es menor a 5
        if (n1 < 5) {
            System.out.println("Pequeño");
        } else {
            System.out.println("Grande");
        }
        System.out.println("\nEjercicio 6b");
        System.out.print("Introduce otro entero: ");
        // Vuelvo a usar scanner.nextInt() y guardo el input en la variable entera nu2
        int n2 = scanner.nextInt();
        // Si el segundo numero es 1, 2, o 3
        if (n2 == 1) {
            System.out.println("Uno"); // En el word sale "no"
        } else if (n2 == 2) {
            System.out.println("Dos");
        } else if (n2 == 3) {
            System.out.println("3"); // Pense ponerlo en texto, pero mejor no
        } else {
            /**En caso de que no sea ninguna de las tres */
            System.out.println("Ni uno, ni dos, ni tres");
        }
        System.out.println();
    }
    
    /** 7.Declarar un entero = 0. Mientras el entero <5, 
     * imprimir su valor y incrementarlo de 1. */
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

    /** 8.Declarar un entero = 10. Mientras el entero >5, 
     * imprimir su valor y decrementarlo de 1, 
     * pero imprime por lo menos una vez su valor. */
    public static void Ejercicio_08(){
        System.out.println("Ejercicio 8\n");
        int numeroX = 10;

        // Hace el decremento del valor hasta llegar a 5
        do {
            System.out.println("Valor: " + numeroX);
            numeroX--;
        } while (numeroX > 5);

        System.out.println();
    }

    /** 9.Crear un bucle que se ejecuta 10 veces utilizando un entero que va de 10 a 19
     *  incrementándose en 1. Imprimir en cada bucle el valor del entero, 
     * menos cuando es igual a 15. */
    public static void Ejercicio_09(){
        System.out.println("Ejercicio 9\n");
        
        // Inicia el contador en 10 y se ejecuta mientras sea menor o igual a 19,
        for (int contador = 10; contador <= 19; contador++) {
            // Si el contador vale 15, salta o imprime ese valor
            if (contador == 15) continue;
            System.out.println("Valor = " + contador);
        }
        System.out.println();
    }

        /** 10.Pedir dos números y decir si son iguales o no*/
    public static void Ejercicio_10(){
        System.out.println("Ejercicio 10\n");
        System.out.print("Número 1: ");
        int n1 = scanner.nextInt();
        System.out.print("Número 2: ");
        int n2 = scanner.nextInt();

        // Si el valor de ambos numeros es igual 
        if (n1 == n2) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
        System.out.println();
    }

        /**  */
    public static void Ejercicio_(){
        System.out.println("Ejercicio \n");
        System.out.println();
    }
}
