package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

public class MateriaTeorica extends Materia {
    private double examenFinal;
    private double tareas;

    public MateriaTeorica(String nombre, int creditos, double examenFinal, double tareas) {
        super(nombre, creditos);
        this.examenFinal = examenFinal;
        this.tareas = tareas;
    }

    // Sobrecarga de constructor (sin tareas)
    public MateriaTeorica(String nombre, int creditos, double examenFinal) {
        this(nombre, creditos, examenFinal, 0);
    }

    @Override
    public double calcularCalificacion() {
        return examenFinal * 0.7 + tareas * 0.3;
    }
}
