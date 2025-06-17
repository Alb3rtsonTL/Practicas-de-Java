package Tarea04_Sistema_AutoAlquiler;

/**
 * Clase Camioneta que representa un vehículo tipo camioneta.
 * Extiende la clase Vehiculo e implementa la interfaz IAlquiler.
 */
public class Camioneta extends Vehiculo implements IAlquiler {
    private double capacidadCarga; // en kg

    /* Constructor de la clase Camioneta */
    public Camioneta(String matricula, String marca, String modelo, int año, double capacidadCarga) {
        super(matricula, marca, modelo, año);
        this.capacidadCarga = capacidadCarga;
    }

    /* Sobrecarga del constructor de la clase Camioneta que incluye el estado */
    public Camioneta(String matricula, String marca, String modelo, int año, double capacidadCarga, String estado) {
        super(matricula, marca, modelo, año, estado);
        this.capacidadCarga = capacidadCarga;
    }

    @Override // Cambia el estado a alquilado si está disponible
    public boolean alquilar() {
        if (estado.equals("disponible")) {
            estado = "alquilado";
            return true;
        }
        return false;
    }

    // Sobrecarga para verificar la capacidad mínima antes de alquilar
    public boolean alquilar(double capacidadMinima) {
        if (estado.equals("disponible") && capacidadCarga >= capacidadMinima) {
            estado = "alquilado";
            return true;
        }
        return false;
    }

    @Override // Cambia el estado a disponible al devolver
    public void devolver() {
        estado = "disponible";
    }

    @Override // Muestra la información de la camioneta y la capacidad de carga
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Capacidad de carga: " + capacidadCarga + " kg");
    }
}
