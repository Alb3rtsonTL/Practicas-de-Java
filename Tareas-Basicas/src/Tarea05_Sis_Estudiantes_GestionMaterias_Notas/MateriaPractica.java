package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

/** Clase que representa una materia práctica que extiende de la clase materia */
public class MateriaPractica extends Materia {
    private double practica;
    private double laboratorio;
    
    /** Constructor de la clase MateriaPractica */
    public MateriaPractica(String nombre, int creditos, double practica, double laboratorio) {
        super(nombre, creditos);
        this.practica = practica;
        this.laboratorio = laboratorio;
    }

    /** Sobrecarga del constructor, solo practica */
    public MateriaPractica(String nombre, int creditos, double practica) {
        this(nombre, creditos, practica, 0.0);
    }

    @Override /** Sobrecarga del método calcularCalificacion */
    public double calcularCalificacion() {
        return practica * 0.6 + laboratorio * 0.4;
    }
}