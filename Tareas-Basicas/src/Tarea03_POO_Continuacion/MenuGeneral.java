package Tarea03_POO_Continuacion;

import java.util.Scanner;

public class MenuGeneral {
    public static void MenuTarea03(){
        
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Menu principal para la tarea 03 POO Continuación
        while (!salir) {
            System.out.println("---------------------------------------------------------------");
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
                case 1:
                    ProductoMenu.menu();
                    break;
                case 2:
                    EventoMenu.menu();
                    break;
                case 3:
                    EstudianteMenu.menu();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del sistema general...");
                    break;
                default:
                    System.out.println("Opción no válida, La opción elegida no existe.");
                    break;
            }
        }

        scanner.close();
    }
}
