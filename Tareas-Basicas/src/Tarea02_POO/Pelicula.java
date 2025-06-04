package Tarea02_POO;

/** * Clase Película Descripción:
 * Modela las propiedades y comportamientos de una película dentro de un sistema
 * de alquiler de películas. */
class Pelicula {
    private String titulo;
    private String director;
    private boolean disponible;

    public Pelicula(String titulo, String director, boolean disponible) {
        this.titulo      = titulo;
        this.director    = director;
        this.disponible  = disponible;
    }
    // getters y setters
    public String getTitulo()             { return titulo; }
    public void   setTitulo(String t)     { this.titulo = t; }
    public String getDirector()           { return director; }
    public void   setDirector(String d)   { this.director = d; }
    public boolean isDisponible()         { return disponible; }
    public void    setDisponible(boolean b){ this.disponible = b; }

    public void alquilar() {
        if (disponible) {
            disponible = false;
            System.out.println(titulo + " ha sido alquilada.");
        } else {
            System.out.println(titulo + " no está disponible.");
        }
    }
    public void devolver() {
        disponible = true;
        System.out.println(titulo + " ha sido devuelta.");
    }
    @Override
    public String toString() {
        return String.format("Película: %s | Director: %s | Disponible: %s",
                             titulo, director, disponible ? "Sí" : "No");
    }
}
