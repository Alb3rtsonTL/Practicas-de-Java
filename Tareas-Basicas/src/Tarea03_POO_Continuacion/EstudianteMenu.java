package Tarea03_POO_Continuacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa un menú para gestionar estudiantes.
 * Permite registrar estudiantes, agregar materias y mostrar detalles.
 */
public class EstudianteMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> estudiantesRegistrados = new ArrayList<>();
        boolean salir = false;

        // Inicializo un estudiante con carrera y sus materias pero individualmente
        Estudiante estEj1 = new Estudiante("Juan Calderon Ramirez", "JCR20231014", "Desarrollo de Software");
        estEj1.agregarMateria("Analisis y Diseño de Sistemas");
        estEj1.agregarMateria("Programación 1");
        estEj1.agregarMateria("Base de Datos Avanzada");
        estEj1.agregarMateria("Calculo Integral");
        estEj1.agregarMateria("Probabilidad y Estadística");
        estEj1.agregarMateria("Etica 3");

        // Inicializo un estudiante sin carrera y con varias materias en una lista
        Estudiante estEj2 = new Estudiante("María López", "B67890");
        List<String> listaMaterias = new ArrayList<>();
        listaMaterias.add("Física I");
        listaMaterias.add("Química General");
        estEj2.agregarListaMaterias(listaMaterias);

        // Agrego los estudiantes a la lista de estudiantes registrados
        estudiantesRegistrados.add(estEj1);
        estudiantesRegistrados.add(estEj2);

        while (!salir) { // Bucle del menú
            System.out.println("-----------------------------------------------");
            System.out.println(" Gestión de Estudiantes");
            System.out.println("-----------------------------------------------");
            System.out.println(" 1. Registrar estudiante -(sin carrera)");
            System.out.println(" 2. Registrar estudiante -(con carrera)");
            System.out.println(" 3. Agregar materias a un estudiante");
            System.out.println(" 4. Mostrar todos los estudiantes");
            System.out.println(" 5. Mostrar total de estudiantes creados");
            System.out.println(" 0. Salir \n");
            System.out.print(" [: Digite una opción\\> ");
            int opSeleccionada = scanner.nextInt();
            scanner.nextLine();

            switch (opSeleccionada) {
                case 1: // Registro un estudiante sin carrera
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Registrar a un estudiante sin asignar la carrera");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Nombre del estudiante: ");
                    String nombre1 = scanner.nextLine();
                    System.out.print(" Matrícula: ");
                    String matricula1 = scanner.nextLine();
                    Estudiante estudiante1 = new Estudiante(nombre1, matricula1);
                    estudiantesRegistrados.add(estudiante1);
                    System.out.println(" Estudiante \"" + nombre1 + "\" registrado.\n");
                    break;

                case 2: // Registro un estudiante con carrera
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Registrar estudiante");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Nombre del estudiante: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print(" Matrícula: ");
                    String matricula2 = scanner.nextLine();
                    System.out.print(" Carrera: ");
                    String carrera2 = scanner.nextLine();
                    Estudiante estudiante2 = new Estudiante(nombre2, matricula2, carrera2);
                    estudiantesRegistrados.add(estudiante2);
                    System.out.println(" Estudiante \"" + nombre2 + "\" registrado.\n");
                    break;

                case 3: // Agrego materias a un estudiante que especifique el usuario
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Agregar materias a un estudiante");
                    System.out.println("-----------------------------------------------");
                    if (estudiantesRegistrados.isEmpty()) {
                        System.out.println(" No hay estudiantes registrados aún.");
                        break;
                    }
                    System.out.println(" Seleccione el estudiante al que desea agregar materias:");
                    for (int i = 0; i < estudiantesRegistrados.size(); i++) {
                        Estudiante e = estudiantesRegistrados.get(i);
                        System.out.println((i + 1) + " . "
                                + e.getNombreEstudiante()
                                + " (Matrícula: " + e.getMatriculaEstudiante() + ")");
                    }
                    System.out.print(" Número de estudiante: ");
                    int indiceEstudiante = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indiceEstudiante < 0 || indiceEstudiante >= estudiantesRegistrados.size()) {
                        System.out.println(" Opción inválida.");
                    } else {
                        System.out
                                .print(" (1) Para agregar una sola materia o (2) para varias materias? Digite 1 o 2: ");
                        int tipoMat = scanner.nextInt();
                        scanner.nextLine();
                        if (tipoMat == 1) {
                            System.out.print(" Nombre de la materia: ");
                            String materia1 = scanner.nextLine();
                            estudiantesRegistrados
                                    .get(indiceEstudiante)
                                    .agregarMateria(materia1);
                            System.out.println(" Materia \"" + materia1 + "\" agregada.");
                        } else if (tipoMat == 2) {
                            System.out.println(" Ingrese nombres de las materias separados por comas:");
                            String lineaMaterias = scanner.nextLine();
                            String[] arrMaterias = lineaMaterias.split(",");
                            List<String> listaMateriasNuevas = new ArrayList<>();
                            for (String m : arrMaterias) {
                                listaMateriasNuevas.add(m.trim());
                            }
                            estudiantesRegistrados
                                    .get(indiceEstudiante)
                                    .agregarListaMaterias(listaMateriasNuevas);
                            System.out.println(" Materias agregadas.\n");
                        } else {
                            System.out.println(" Opción invalida, la opción digitada no existe.\n");
                        }
                    }
                    break;

                case 4: // Muestro todos los estudiantes
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Lista de estudiantes registrados");
                    System.out.println("-----------------------------------------------");
                    if (estudiantesRegistrados.isEmpty()) {
                        System.out.println(" No hay ningún estudiante registrado.");
                    } else {
                        for (Estudiante e : estudiantesRegistrados) {
                            e.mostrarDetallesEstudiante();
                        }
                    }
                    break;

                case 5: // Muestro el total de estudiantes creados
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Total de estudiantes creados: " + Estudiante.obtenerTotalEstudiantes());
                    break;

                case 0: // Salgo del menú
                    salir = true;
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Saliendo del gestor de estudiantes...");
                    break;

                default: // Si la opción no existe
                    System.out.println("-----------------------------------------------");
                    System.out.println(" La opción no existe en el menú..");
                    break;
            }
        }
    }
}
