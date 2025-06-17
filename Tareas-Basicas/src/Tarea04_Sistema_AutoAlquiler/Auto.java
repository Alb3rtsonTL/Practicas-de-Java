package Tarea04_Sistema_AutoAlquiler;

/**
 * Clase Auto que representa un vehículo tipo auto.
 * Extiende la clase Vehiculo e implementa la interfaz IAlquiler.
 */
public class Auto extends Vehiculo implements IAlquiler {
    private int numeroPuertas;

    /* Constructor de la clase Auto */
    public Auto(String matricula, String marca, String modelo, int año, int numeroPuertas) {
        super(matricula, marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }

    /* Sobrecarga del constructor de la clase Auto que incluye el estado */
    public Auto(String matricula, String marca, String modelo, int año, int numeroPuertas, String estado) {
        super(matricula, marca, modelo, año, estado);
        this.numeroPuertas = numeroPuertas;
    }

    @Override // Cambia el estado a alquilado si está disponible
    public boolean alquilar() {
        if (estado.equals("disponible")) {
            estado = "alquilado";
            return true;
        }
        return false;
    }

    @Override // Cambia el estado a disponible al devolver
    public void devolver() {
        estado = "disponible";
    }

    @Override // Muestra la información del auto, incluyendo el número de puertas
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de puertas: " + numeroPuertas);
    }
}
