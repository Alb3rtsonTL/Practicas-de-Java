package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

/** Clase que representa una materia teorica que extiende de la clase materia */
public class MateriaTeorica extends Materia {
    private double examenFinal;
    private double tareas;

    /** Constructor de la clase MateriaTeorica */
    public MateriaTeorica(String nombre, int creditos, double examenFinal, double tareas) {
        super(nombre, creditos);
        this.examenFinal = examenFinal;
        this.tareas = tareas;
    }

    /** Sobrecarga de constructor, para solo la nota del examen final*/
    public MateriaTeorica(String nombre, int creditos, double examenFinal) {
        this(nombre, creditos, examenFinal, 0);
    }

    @Override /** Sobrecarga del método calcularCalificacion */
    public double calcularCalificacion() {
        return examenFinal * 0.7 + tareas * 0.3;
    }

}
