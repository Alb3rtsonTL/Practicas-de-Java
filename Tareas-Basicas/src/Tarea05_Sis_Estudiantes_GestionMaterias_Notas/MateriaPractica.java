package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

public class MateriaPractica extends Materia {
    private double proyecto;
    private double laboratorio;

    public MateriaPractica(String nombre, int creditos, double proyecto, double laboratorio) {
        super(nombre, creditos);
        this.proyecto = proyecto;
        this.laboratorio = laboratorio;
    }

    // Sobrecarga de constructor (solo proyecto)
    public MateriaPractica(String nombre, int creditos, double proyecto) {
        this(nombre, creditos, proyecto, 0);
    }

    @Override
    public double calcularCalificacion() {
        return proyecto * 0.6 + laboratorio * 0.4;
    }
}
