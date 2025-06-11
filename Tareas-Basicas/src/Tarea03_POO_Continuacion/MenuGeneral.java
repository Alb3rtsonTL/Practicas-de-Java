package Tarea03_POO_Continuacion;

import java.util.Scanner;

/* Clase del menu general para la Tarea 03 POO Continuación  */
public class MenuGeneral {
    public static void MenuTarea03() {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) { // Menu principal
            System.out.println("\n---------------------------------------------------------------");
            System.out.println(" Menú General de Gestores");
            System.out.println("---------------------------------------------------------------");
            System.out.println(" 1. Gestor de Productos");
            System.out.println(" 2. Gestor de Eventos");
            System.out.println(" 3. Gestor de Estudiantes");
            System.out.println(" 0. Salir");
            System.out.print(" [: Digite una opción\\> ");
            int opSeleccionada = scanner.nextInt();
            scanner.nextLine();

            switch (opSeleccionada) {
                case 1: ProductoMenu.menu();
                    break;
                case 2: EventoMenu.menu();
                    break;
                case 3: EstudianteMenu.menu();
                    break;
                case 0: // Salgo del menú
                    salir = true;
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Saliendo del sistema de productos...");
                    break;
                default: // Si la opción no existe
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" La opción no existe en el menú..]\n");
                    break;
            }
        }
        scanner.close();
    }
}
