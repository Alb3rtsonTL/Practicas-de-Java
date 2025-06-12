package Tarea03_POO_Continuacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa un menú para gestionar eventos.
 * Permite crear eventos, agregar invitados, mostrar detalles y filtrar por fecha o lugar.
 */
public class EventoMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Evento> eventosRegistrados = new ArrayList<>();
        boolean salir = false;
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("d/M/yyyy");

        try {
            // Evento 1
            Evento eventoEj1 = new Evento(
                "Concierto Cristiano",
                LocalDate.parse("15/06/2025", formatoEntrada),
                "Concierto de Redimi2, Alexezurdo y Funky.",
                "Redimi2 Producciones"
            );
            eventoEj1.agregarInvitado("Alexandra López");
            eventoEj1.agregarInvitado("Casandra Terrero López");
            eventoEj1.agregarInvitado("España Terrero López");

            // Evento 2
            Evento eventoEj2 = new Evento(
                "ITLA DevTech Fest 2025",
                LocalDate.parse("04/07/2025", formatoEntrada),
                "Auditorio 1",
                "Exposición de proyectos científicos de estudiantes.",
                "ITLA"
            );
            List<String> listaInvitados2 = new ArrayList<>();
            listaInvitados2.add("Robert Ramirez Feliz");
            listaInvitados2.add("Daniel del Carmen Terrero");
            eventoEj2.agregarListaInvitados(listaInvitados2);

            eventosRegistrados.add(eventoEj1);
            eventosRegistrados.add(eventoEj2);
        } catch (DateTimeParseException e) {
            System.out.println("Error al convertir la fecha " + e.getMessage());
        }

        while (!salir) { // Este es el bucle para el menu
            System.out.println("---------------------------------------------------------------");
            System.out.println(" Gestión de Eventos");
            System.out.println("---------------------------------------------------------------");
            System.out.println(" 1. Crear evento (sin lugar)");
            System.out.println(" 2. Crear evento (con lugar)");
            System.out.println(" 3. Agregar invitados a un evento");
            System.out.println(" 4. Mostrar todos los eventos");
            System.out.println(" 5. Mostrar total de eventos creados");
            System.out.println(" 6. Mostrar eventos por fecha");
            System.out.println(" 7. Mostrar lista de lugares registrados");
            System.out.println(" 8. Mostrar eventos de un lugar específico");
            System.out.println(" 0. Salir");
            System.out.print(" Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: // Creo un evento sin lugar
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Crear Evento sin asignar un lugar");
                    System.out.println("---------------------------------------------------------------");
                    try {
                        System.out.print(" Nombre del evento: ");
                        String nombreE1 = scanner.nextLine();
                        System.out.print(" Descripción del evento: ");
                        String descripcionE1 = scanner.nextLine();
                        System.out.print(" Organizador del evento: ");
                        String organizadorE1 = scanner.nextLine();
                        System.out.print(" Fecha (d/M/yyyy): ");
                        String textoFecha1 = scanner.nextLine();
                        LocalDate fechaE1 = LocalDate.parse(textoFecha1, formatoEntrada);
                        Evento eventoNuevo1 = new Evento(nombreE1, fechaE1, descripcionE1, organizadorE1);
                        eventosRegistrados.add(eventoNuevo1);
                        System.out.println(" Evento \"" + nombreE1 + "\" creado sin asignar un lugar.");
                    } catch (DateTimeParseException e) {
                        System.out.println(" Formato de fecha inválido. Use d/M/yyyy.");
                    }
                    break;

                case 2: // Crear evento con lugar
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Crear Evento asignando un lugar");
                    System.out.println("---------------------------------------------------------------");
                    try {
                        System.out.print(" Nombre del evento: ");
                        String nombreE2 = scanner.nextLine();
                        System.out.print(" Descripción del evento: ");
                        String descripcionE2 = scanner.nextLine();
                        System.out.print(" Organizador del evento: ");
                        String organizadorE2 = scanner.nextLine();
                        System.out.print(" Fecha (d/M/yyyy): ");
                        String textoFecha2 = scanner.nextLine();
                        LocalDate fechaE2 = LocalDate.parse(textoFecha2, formatoEntrada);
                        System.out.print(" Lugar del evento: ");
                        String lugarE2 = scanner.nextLine();
                        Evento eventoNuevo2 = new Evento(nombreE2, fechaE2, lugarE2, descripcionE2, organizadorE2);
                        eventosRegistrados.add(eventoNuevo2);
                        System.out.println(" Evento \"" + nombreE2 + "\" creado.");
                    } catch (DateTimeParseException e) {
                        System.out.println(" Formato de fecha inválido. Use d/M/yyyy");
                    }
                    break;

                case 3: // Agrego los invitados a un evento seleccionado
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Agregar invitados a un evento especifico");
                    System.out.println("---------------------------------------------------------------");
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println(" No hay eventos registrados aún.");
                        break;
                    }
                    System.out.println(" Seleccione el evento al que desea agregar invitados:");
                    for (int i = 0; i < eventosRegistrados.size(); i++) {
                        Evento ev = eventosRegistrados.get(i);
                        System.out.println((i + 1) + ". "
                                + ev.getNombreEvento() + " ("
                                + ev.getFechaEvento().format(formatoEntrada) + ")");
                    }
                    System.out.print(" Número de evento: ");
                    int indiceEvento = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indiceEvento < 0 || indiceEvento >= eventosRegistrados.size()) {
                        System.out.println(" Opción inválida.");
                    } else {
                        System.out.print(" ¿Agregar (1) un solo invitado o (2) varios invitados? Ingrese 1 o 2: ");
                        int tipoInv = scanner.nextInt();
                        scanner.nextLine();
                        if (tipoInv == 1) {
                            System.out.print(" Nombre del invitado: ");
                            String nombreInv = scanner.nextLine();
                            eventosRegistrados
                                    .get(indiceEvento)
                                    .agregarInvitado(nombreInv);
                            System.out.println(" Invitado \"" + nombreInv + "\" agregado.");
                        } else if (tipoInv == 2) {
                            System.out.println(" Ingrese nombres de invitados separados por comas:");
                            String lineaInv = scanner.nextLine();
                            String[] arrInvitados = lineaInv.split(",");
                            List<String> listaNuevos = new ArrayList<>();
                            for (String inv : arrInvitados) {
                                listaNuevos.add(inv.trim());
                            }
                            eventosRegistrados
                                    .get(indiceEvento)
                                    .agregarListaInvitados(listaNuevos);
                            System.out.println(" Invitados agregados.");
                        } else {
                            System.out.println(" Opción inválida.");
                        }
                    }
                    break;

                case 4: // Muestro todos los eventos
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Eventos registrados en el sistema");
                    System.out.println("---------------------------------------------------------------");
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println(" No hay eventos registrados.");
                    } else {
                        for (Evento e : eventosRegistrados) {
                            e.mostrarDetallesEvento();
                        }
                    }
                    break;

                case 5: // Muestro el total de eventos creados
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Total de eventos creados: " + Evento.obtenerTotalEventos());
                    break;

                case 6: // Muestro los eventos por fecha
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Filtrar los eventos por fecha");
                    System.out.println("---------------------------------------------------------------");
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println(" No hay eventos registrados.");
                        break;
                    }
                    System.out.print(" Ingrese la fecha a buscar (d/M/yyyy): ");
                    String textoFechaBuscar = scanner.nextLine();
                    try {
                        LocalDate fechaBuscar = LocalDate.parse(textoFechaBuscar, formatoEntrada);
                        boolean hallado = false;
                        System.out.println(" Eventos en la fecha " + textoFechaBuscar + ":");
                        for (Evento ev : eventosRegistrados) {
                            if (ev.getFechaEvento().equals(fechaBuscar)) {
                                ev.mostrarDetallesEvento();
                                hallado = true;
                            }
                        }
                        if (!hallado) {
                            System.out.println(" No se encontraron eventos en esa fecha.");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println(" Formato de fecha inválido. Use d/M/yyyy.");
                    }
                    break;

                case 7: // Muestro la lista de lugares registrados
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Filtro los lugares eventos sin repetir el lugar");
                    System.out.println("---------------------------------------------------------------");
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println(" No hay eventos registrados.");
                        break;
                    }
                    System.out.println(" Lugares de eventos registrados:");
                    ArrayList<String> lugaresUnicos = new ArrayList<>();
                    for (Evento ev : eventosRegistrados) {
                        String lugar = ev.getLugarEvento();
                        if (!lugaresUnicos.contains(lugar)) {
                            lugaresUnicos.add(lugar);
                        }
                    }
                    for (String lugar : lugaresUnicos) {
                        System.out.println("->" + lugar);
                    }
                    break;

                case 8: // Muestro los eventos de un lugar específico
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Buscar eventos registrados en el sistema");
                    System.out.println("---------------------------------------------------------------");
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println(" No hay eventos registrados.");
                        break;
                    }
                    System.out.print(" Escriba el nombre exacto del lugar a buscar: ");
                    String lugarBuscado = scanner.nextLine();
                    boolean encontradoLugar = false;
                    for (Evento ev : eventosRegistrados) {
                        if (ev.getLugarEvento().equalsIgnoreCase(lugarBuscado.trim())) {
                            ev.mostrarDetallesEvento();
                            encontradoLugar = true;
                        }
                    }
                    if (!encontradoLugar) {
                        System.out.println(" No se encontraron eventos en \"" + lugarBuscado + "\".");
                    }
                    break;

                case 0: // Salgo del menú
                    salir = true;
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Saliendo del sistema de productos...");
                    break;

                default: // Si la opción no existe
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" La opción no existe. Esa opción no existe en el menú..]\n");
                    break;
            }
        }
    }
}
