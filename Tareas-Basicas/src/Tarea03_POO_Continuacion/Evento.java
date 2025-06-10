package Tarea03_POO_Continuacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombreEvento;
    private LocalDate fechaEvento;
    private String lugarEvento;
    private List<String> invitados;
    private static int totalEventos = 0;

    // Constructor que recibe solo el nombreEvento y fechaEvento; para cuando el
    // lugarEvento esta sin especificar
    public Evento(String nombreEvento, LocalDate fechaEvento) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugarEvento = "Sin especificar";
        this.invitados = new ArrayList<>();
        totalEventos++;
    }

    // Constructor sobrecargado este recibe el nombreEvento, la fechaEvento y
    // lugarEvento
    public Evento(String nombreEvento, LocalDate fechaEvento, String lugarEvento) {
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.lugarEvento = lugarEvento;
        this.invitados = new ArrayList<>();
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
        System.out.println("---------------------------------");
    }

    // Getters para obtener los datos del evento
    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    // Método estático que devuelve cuántos eventos se han creado
    public static int obtenerTotalEventos() {
        return totalEventos;
    }
}