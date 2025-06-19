package Tarea05_Sis_Estudiantes_GestionMaterias_Notas;

/* Clase abstracta para representar una materia */
public abstract class Materia {
    private String nombre;
    private int creditos;

    /* Constructor de la clase Materia */
    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre () { return nombre;}
    public int getCreditos() { return creditos;}

    /* Clase abstracta para calcular la calificación como un double */
    public abstract double calcularCalificacion();

}
