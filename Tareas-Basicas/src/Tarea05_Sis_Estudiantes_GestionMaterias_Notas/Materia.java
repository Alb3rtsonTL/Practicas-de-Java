package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

/** Clase abstracta para representar una materia */
public abstract class Materia {
    private String nombre;
    private int creditos;

    /** Constructor de la clase Materia */
    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    /** Método para obtener el nombre de la materia */
    public String getNombre () { return nombre;}
    /** Método para obtener los créditos de la materia */
    public int getCreditos() { return creditos;}

    /** Clase abstracta para calcular la calificación como un double */
    public abstract double calcularCalificacion();

}
