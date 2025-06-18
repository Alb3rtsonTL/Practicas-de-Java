package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

public abstract class Materia {
    private String nombre;
    private int creditos;

    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }

    public abstract double calcularCalificacion();
}
