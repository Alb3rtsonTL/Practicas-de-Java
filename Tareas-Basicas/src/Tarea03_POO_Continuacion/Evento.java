package Tarea03_POO_Continuacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un evento con sus datos y lista de invitados.
 * Permite registrar eventos, agregar invitados y mostrar detalles.
 */
public class Evento {
    private String nombreEvento;
    private LocalDate fechaEvento;
    private String lugarEvento;
    private List<String> invitados;
    private static int totalEventos = 0;
    private String descripcion;
    private String organizador;

    // Constructor que recibe solo el nombreEvento y fechaEvento
    public Evento(String nombreEvento, LocalDate fechaEvento, String descripcion, String organizador) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugarEvento = "Sin especificar";
        this.invitados = new ArrayList<>();
        this.descripcion = descripcion;
        this.organizador = organizador;
        totalEventos++;
    }

    // Constructor sobrecargado que recibe nombreEvento, fechaEvento, lugarEvento, descripcion y organizador
    public Evento(String nombreEvento, LocalDate fechaEvento, String lugarEvento, String descripcion, String organizador) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugarEvento = lugarEvento;
        this.invitados = new ArrayList<>();
        this.descripcion = descripcion;
        this.organizador = organizador;
        totalEventos++;
    }

    // Método para agregar varios invitados
    public void agregarListaInvitados(List<String> listaNuevosInvitados) {
        this.invitados.addAll(listaNuevosInvitados);
    }

    // Método sobrecargado para agregar un solo invitado
    public void agregarInvitado(String nombreInvitado) {
        this.invitados.add(nombreInvitado);
    }

    // Mostrar todos los datos del evento
    public void mostrarDetallesEvento() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(" Evento: " + nombreEvento);
        System.out.println(" Descripción: " + descripcion);
        System.out.println(" Organizador: " + organizador);
        System.out.println(" Fecha: " + fechaEvento.format(formatoFecha));
        System.out.println(" Lugar: " + lugarEvento);
        System.out.println(" Listado de invitados:");
        if (invitados.isEmpty()) {
            System.out.println("   (Sin invitados registrados)");
        } else {
            for (String inv : invitados) {
                System.out.println("   - " + inv);
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

    // Getters para obtener los datos del evento
    public LocalDate getFechaEvento() { return fechaEvento; }
    public String getLugarEvento() { return lugarEvento; }
    public String getNombreEvento() { return nombreEvento; }
    public String getDescripcion() { return descripcion; }
    public String getOrganizador() { return organizador; }

    // Método estático que devuelve cuántos eventos se han creado
    public static int obtenerTotalEventos() {
        return totalEventos;
    }
}