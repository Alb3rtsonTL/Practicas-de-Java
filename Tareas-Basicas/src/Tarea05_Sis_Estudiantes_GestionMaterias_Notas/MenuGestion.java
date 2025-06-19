package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestion {

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EstudianteUniversitario> estudiantes = new ArrayList<>();
        boolean salir = false;

        // Agregue estudiantes con materias y calificaciones
        EstudianteUniversitario est1 = new EstudianteUniversitario("Alexandra López");
        est1.agregarMateria(new MateriaTeorica("Matemáticas", 4, 90, 85));
        est1.agregarMateria(new MateriaPractica("Programación", 5, 95, 90));
        estudiantes.add(est1);

        EstudianteUniversitario est2 = new EstudianteUniversitario("Daniel Feliz");
        est2.agregarMateria(new MateriaTeorica("Historia Dominicana", 4, 80, 70));
        est2.agregarMateria(new MateriaPractica("Física General", 4, 88, 92));
        est2.agregarMateria(new MateriaPractica("Laboratorio Física General", 1, 98, 100));
        estudiantes.add(est2);

        EstudianteUniversitario est3 = new EstudianteUniversitario("Winifer Terrero");
        est3.agregarMateria(new MateriaTeorica("Filosofía", 2, 75, 80));
        est3.agregarMateria(new MateriaPractica("Química", 3, 85, 92));
        est3.agregarMateria(new MateriaTeorica("Lengua Española", 3, 95, 90));
        estudiantes.add(est3);

        while (!salir) { // Menu principal
            System.out.println("\n-----------------------------------------------");
            System.out.println(" Sistema de Gestión de Materias y Notas");
            System.out.println("-----------------------------------------------");
            System.out.println(" 1. Agregar un nuevo estudiante");
            System.out.println(" 2. Agregar materia a un estudiante");
            System.out.println(" 3. Calcular el promedio de un estudiante");
            System.out.println(" 4. Mostrar las materias de un estudiante");
            System.out.println(" 0. Salir");
            System.out.print(" [: Digite una opción\\> ");
            int opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1: // Agregar un nuevo estudiante
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Agregar un nuevo estudiante");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Nombre del estudiante: ");
                    String nombreEst = scanner.nextLine();
                    estudiantes.add(new EstudianteUniversitario(nombreEst));
                    System.out.println(" Estudiante agregado.");
                    break;

                case 2: // Agregar materia a un estudiante
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Agregar materia a un estudiante");
                    System.out.println("-----------------------------------------------");

                    if (estudiantes.isEmpty()) {
                        System.out.println(" No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println(" Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxEstudiante = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (idxEstudiante < 0 || idxEstudiante >= estudiantes.size()) {
                        System.out.println(" Opción inválida.");
                        break;
                    }
                    System.out.print(" Tipo de materia (1=Teórica, 2=Práctica): ");
                    int tipoMateria = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(" Nombre de la materia: ");
                    String nombreMat = scanner.nextLine();
                    System.out.print(" Créditos: ");
                    int creditos = scanner.nextInt();
                    scanner.nextLine();
                    if (tipoMateria == 1) {
                        System.out.print(" Nota examen final: ");
                        double examen = scanner.nextDouble();
                        System.out.print(" Nota tareas: ");
                        double tareas = scanner.nextDouble();
                        scanner.nextLine();
                        estudiantes.get(idxEstudiante).agregarMateria(new MateriaTeorica(nombreMat, creditos, examen, tareas));
                    } else if (tipoMateria == 2) {
                        System.out.print(" Nota proyecto: ");
                        double proyecto = scanner.nextDouble();
                        System.out.print(" Nota laboratorio: ");
                        double lab = scanner.nextDouble();
                        scanner.nextLine();
                        estudiantes.get(idxEstudiante).agregarMateria(new MateriaPractica(nombreMat, creditos, proyecto, lab));
                    } else {
                        System.out.println(" Tipo de materia inválido.");
                    }
                    System.out.println(" Materia agregada.");
                    break;

                case 3: // Calcular el promedio de un estudiante
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Calcular el promedio de un estudiante");
                    System.out.println("-----------------------------------------------");

                    if (estudiantes.isEmpty()) {
                        System.out.println(" No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println(" Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxProm = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (idxProm < 0 || idxProm >= estudiantes.size()) {
                        System.out.println(" Opción inválida.");
                        break;
                    }
                    double promedio = estudiantes.get(idxProm).calcularPromedio();
                    System.out.printf("Promedio de %s: %.2f\n", estudiantes.get(idxProm).getNombre(), promedio);
                    break;

                case 4: // Mostrar las materias de un estudiante
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Mostrar las materias de un estudiante");
                    System.out.println("-----------------------------------------------");

                    if (estudiantes.isEmpty()) {
                        System.out.println(" No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println(" Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxMat = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (idxMat < 0 || idxMat >= estudiantes.size()) {
                        System.out.println(" Opción inválida.");
                        break;
                    }
                    ArrayList<Materia> mats = estudiantes.get(idxMat).getMaterias();
                    if (mats.isEmpty()) {
                        System.out.println(" No hay materias registradas.");
                    } else {
                        for (Materia m : mats) {
                            System.out.println(" - " + m.getNombre() + " (" + m.getCreditos()
                                    + " créditos), Calificación: " + m.calcularCalificacion());
                        }
                    }
                    break;

                case 0: // Salgo del menú
                    salir = true;
                    scanner.close();
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Saliendo del Menú general del sistema...");
                    break;

                default: // Si la opción no existe
                    System.out.println("-----------------------------------------------");
                    System.out.println(" La opción no existe en el menú..]\n");
                    break;
            }
        }
    }
}
