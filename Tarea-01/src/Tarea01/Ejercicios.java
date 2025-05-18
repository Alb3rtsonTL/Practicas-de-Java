package Tarea01;

import java.util.Scanner;

public class Ejercicios {
    
    private static final Scanner scanner = new Scanner(System.in);

    /** 1.Declarar variable de los diferentes tipos, asignarles valor e imprimir el valor. */
    public static void Ejercicio_01() {
        System.out.println("Ejercicio 1");
        int entero = 42;
        double doble = 3.14;
        char caracter = 'A';
        boolean booleano = true;
        String texto = "Este fue el primer ejercicio \n";
        System.out.println("Entero: " + entero);
        System.out.println("Punto flotante creo: " + doble);
        System.out.println("Caracter: " + caracter);
        System.out.println("Buleano: " + booleano);
        System.out.println("Texto: " + texto);
    }

    /** 2.Buscar cómo se declara una constante en java e imprimir el valor. Probar de cambiar su valor luego y ver que es lo que pasa. */
    public static void Ejercicio_02() {
        System.out.println("Ejercicio 2");
        final String CONSTANTE = "100 Carros";
        System.out.println("Constante = " + CONSTANTE);
    }

    /** 3.Declara un entero, incrementarlo, decrementarlo, hacer operaciones con el. */
    public static void Ejercio_03()
    {
        int numeroX = 16;
        System.out.println("El numero ahora es: "+ numeroX);
        numeroX++;
        System.out.println("Incremento: "+ numeroX);
        --numeroX;
        System.out.println("Decremento: "+ numeroX);

        int suma = numeroX + 5;
        int producto = numeroX * 2;
        System.out.println("Numero: " + numeroX);
        System.out.println("Suma: " + suma);
        System.out.println("Producto: " + producto);
    }
    
    /** 4.Declarar un float con valor = 10152466.25. Declarar un byte que es igual a 5 + el float. */    
    public static void Ejercicio_04()
    {
        System.out.println("\nEjercicio 4");
        float valorFloat = 10152466.25f;
        
        // Sumo el flotante al entero y luego asigno a byte
        byte resultado = (byte)(5 + valorFloat);
        
        System.out.println("Decimal: " + valorFloat);
        System.out.println("Byte (5 + flotante): " + resultado);
        System.out.println(); 
    }

    public static void Ejercicio_(){}
}
