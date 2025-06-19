package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

/** Intefaz Estudiante que representa los metodos abstractos del estudiante*/
public interface Estudiante {
    /** Metodo para agregar una materia al registro del estudiante. */
    void agregarMateria(Materia materia);
    /** Metodo para calcular el promedio de calificaciones de las materias del estudiante. */
    double calcularPromedio();
}
