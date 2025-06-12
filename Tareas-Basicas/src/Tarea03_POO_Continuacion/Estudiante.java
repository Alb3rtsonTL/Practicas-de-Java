package Tarea03_POO_Continuacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un estudiante con sus datos y materias inscritas.
 * Permite registrar estudiantes, agregar materias y mostrar detalles.
 */
public class Estudiante {
    private String nombreEstudiante;
    private String matriculaEstudiante;
    private String carreraEstudiante;
    private List<String> materiasInscritas;
    private static int totalEstudiantes = 0;

    // Constructor que recibe nombreEstudiante y matriculaEstudiante;
    // carreraEstudiante queda como sin especificar
    public Estudiante(String nombreEstudiante, String matriculaEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.matriculaEstudiante = matriculaEstudiante;
        this.carreraEstudiante = "Sin especificar";
        this.materiasInscritas = new ArrayList<>();
        totalEstudiantes++;
    }

    // Constructor sobrecargado que también recibe la carreraEstudiante
    public Estudiante(String nombreEstudiante, String matriculaEstudiante, String carreraEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.matriculaEstudiante = matriculaEstudiante;
        this.carreraEstudiante = carreraEstudiante;
        this.materiasInscritas = new ArrayList<>();
        totalEstudiantes++;
    }

    // Método para agregar varias materias
    public void agregarListaMaterias(List<String> listaMateriasNuevas) {
        this.materiasInscritas.addAll(listaMateriasNuevas);
    }

    // Método sobrecargado para agregar una sola materia
    public void agregarMateria(String nombreMateria) {
        this.materiasInscritas.add(nombreMateria);
    }

    // Mostrar todos los datos del estudiante
    public void mostrarDetallesEstudiante() {
        System.out.println("-----------------------------------------------");
        System.out.println(" Nombre: " + nombreEstudiante);
        System.out.println(" Matrícula: " + matriculaEstudiante);
        System.out.println(" Carrera: " + carreraEstudiante);
        System.out.println(" Materias inscritas:");
        if (materiasInscritas.isEmpty()) {
            System.out.println("   (No hay materias inscritas)");
        } else {
            for (String mat : materiasInscritas) {
                System.out.println("   - " + mat);
            }
        }
    }

    // Getters para para el nombre y matricula del estudiante
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getMatriculaEstudiante() {
        return matriculaEstudiante;
    }

    // Método estático que devuelve cuántos estudiantes se han creado
    public static int obtenerTotalEstudiantes() {
        return totalEstudiantes;
    }
}