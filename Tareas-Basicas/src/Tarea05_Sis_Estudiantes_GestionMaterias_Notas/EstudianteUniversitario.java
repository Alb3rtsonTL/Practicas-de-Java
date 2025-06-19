package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

import java.util.ArrayList;

/** Clase que representa al Estudiante Universitario esta clase 
 * implementa de la interfaz materia sus metodos */
public class EstudianteUniversitario implements Estudiante {
    private String nombre;
    private ArrayList<Materia> materias;

    /** Constructor principal que inicializa los atributos */
    public EstudianteUniversitario(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    @Override /** Agrega una materia a la lista */
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    @Override /** Devuelve el promedio de las materias cursadas */
    public double calcularPromedio() {
        if (materias.isEmpty()) return 0;
        double suma = 0;

        for (Materia m : materias) {
            suma += m.calcularCalificacion();
        }
        return suma / materias.size();
    }

    /** Devuelve el nombre del estudiante */
    public String getNombre() { return nombre; }

    /** Retorna las materias  */
    public ArrayList<Materia> getMaterias() { return materias; }
}
