package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

import java.util.ArrayList;

public class EstudianteUniversitario implements Estudiante {
    private String nombre;
    private ArrayList<Materia> materias;

    public EstudianteUniversitario(String nombre) {
        this.nombre = nombre;
        this.materias = new ArrayList<>();
    }

    @Override
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    @Override
    public double calcularPromedio() {
        if (materias.isEmpty()) return 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.calcularCalificacion();
        }
        return suma / materias.size();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
}
