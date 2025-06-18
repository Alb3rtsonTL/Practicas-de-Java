package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EstudianteUniversitario> estudiantes = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Materias y Notas ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Agregar materia a estudiante");
            System.out.println("3. Calcular y mostrar promedio de estudiante");
            System.out.println("4. Mostrar materias de estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombreEst = sc.nextLine();
                    estudiantes.add(new EstudianteUniversitario(nombreEst));
                    System.out.println("Estudiante agregado.");
                    break;
                case 2:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println("Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxEst = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxEst < 0 || idxEst >= estudiantes.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    System.out.print("Tipo de materia (1=Teórica, 2=Práctica): ");
                    int tipoMat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre de la materia: ");
                    String nombreMat = sc.nextLine();
                    System.out.print("Créditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();
                    if (tipoMat == 1) {
                        System.out.print("Nota examen final: ");
                        double examen = sc.nextDouble();
                        System.out.print("Nota tareas: ");
                        double tareas = sc.nextDouble();
                        sc.nextLine();
                        estudiantes.get(idxEst).agregarMateria(new MateriaTeorica(nombreMat, creditos, examen, tareas));
                    } else if (tipoMat == 2) {
                        System.out.print("Nota proyecto: ");
                        double proyecto = sc.nextDouble();
                        System.out.print("Nota laboratorio: ");
                        double lab = sc.nextDouble();
                        sc.nextLine();
                        estudiantes.get(idxEst).agregarMateria(new MateriaPractica(nombreMat, creditos, proyecto, lab));
                    } else {
                        System.out.println("Tipo de materia inválido.");
                    }
                    System.out.println("Materia agregada.");
                    break;
                case 3:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println("Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxProm = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxProm < 0 || idxProm >= estudiantes.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    double promedio = estudiantes.get(idxProm).calcularPromedio();
                    System.out.printf("Promedio de %s: %.2f\n", estudiantes.get(idxProm).getNombre(), promedio);
                    break;
                case 4:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }
                    System.out.println("Seleccione estudiante:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre());
                    }
                    int idxMat = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxMat < 0 || idxMat >= estudiantes.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    ArrayList<Materia> mats = estudiantes.get(idxMat).getMaterias();
                    if (mats.isEmpty()) {
                        System.out.println("No hay materias registradas.");
                    } else {
                        for (Materia m : mats) {
                            System.out.println("- " + m.getNombre() + " (" + m.getCreditos() + " créditos), Calificación: " + m.calcularCalificacion());
                        }
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
