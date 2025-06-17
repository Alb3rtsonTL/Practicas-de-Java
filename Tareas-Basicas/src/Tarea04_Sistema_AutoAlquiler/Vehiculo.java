package Tarea04_Sistema_AutoAlquiler;

/* Clase abstracta Vehiculo que representa un vehículo genérico. */
public abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int año;
    protected String estado; // disponible o alquilado

    /* Constructor de la clase Vehiculo */
    public Vehiculo(String matricula, String marca, String modelo, int año) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.estado = "disponible";
    }

    /* Sobrecarga del constructor de la clase Vehiculo que incluye el estado */
    public Vehiculo(String matricula, String marca, String modelo, int año, String estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.estado = estado;
    }

    // Getters para acceder a los atributos del vehículo
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public String getEstado() { return estado; }

    /* Método para mostrar la información del vehículo */
    public void mostrarInformacion() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Estado: " + estado);
    }
}
