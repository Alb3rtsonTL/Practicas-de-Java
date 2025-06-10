package Tarea03_POO_Continuacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Evento> eventosRegistrados = new ArrayList<>();
        boolean terminar = false;
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("d/M/yyyy");

        // Ejemplos por defecto:
        try {
            // Evento 1: Concierto de Rock sin lugar especificado inicialmente
            Evento eventoEj1 = new Evento("Concierto Rock Live", LocalDate.parse("15/06/2025", formatoEntrada));
            eventoEj1.agregarInvitado("Ana Martínez");
            eventoEj1.agregarInvitado("Carlos Gómez");
            // Lugar predeterminado: "Sin especificar"

            // Evento 2: Feria de Ciencias con lugar
            Evento eventoEj2 = new Evento("Feria de Ciencias 2025", LocalDate.parse("04/07/2025", formatoEntrada),
                    "Auditorio Central");
            List<String> listaInvitados2 = new ArrayList<>();
            listaInvitados2.add("Laura Fernández");
            listaInvitados2.add("Pedro López");
            listaInvitados2.add("María Ruiz");
            eventoEj2.agregarListaInvitados(listaInvitados2);

            eventosRegistrados.add(eventoEj1);
            eventosRegistrados.add(eventoEj2);
        } catch (DateTimeParseException e) {
            System.out.println("Error al parsear fecha de ejemplo: " + e.getMessage());
        }

        while (!terminar) {
            System.out.println("\n=== MENÚ GESTIÓN DE EVENTOS ===");
            System.out.println("1. Crear evento (sin lugar)");
            System.out.println("2. Crear evento (con lugar)");
            System.out.println("3. Agregar invitados a un evento");
            System.out.println("4. Mostrar todos los eventos");
            System.out.println("5. Mostrar total de eventos creados");
            System.out.println("6. Mostrar eventos por fecha");
            System.out.println("7. Mostrar lista de lugares registrados");
            System.out.println("8. Mostrar eventos de un lugar específico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir salto de línea

            switch (opcion) {
                case 1:
                    // Crear evento sin lugar
                    try {
                        System.out.print("Nombre del evento: ");
                        String nombreE1 = scanner.nextLine();
                        System.out.print("Fecha (d/M/yyyy): ");
                        String textoFecha1 = scanner.nextLine();
                        LocalDate fechaE1 = LocalDate.parse(textoFecha1, formatoEntrada);
                        Evento eventoNuevo1 = new Evento(nombreE1, fechaE1);
                        eventosRegistrados.add(eventoNuevo1);
                        System.out.println("Evento \"" + nombreE1 + "\" creado (sin lugar).");
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido. Use d/M/yyyy (ej.: 2/3/2023).");
                    }
                    break;

                case 2:
                    // Crear evento con lugar
                    try {
                        System.out.print("Nombre del evento: ");
                        String nombreE2 = scanner.nextLine();
                        System.out.print("Fecha (d/M/yyyy): ");
                        String textoFecha2 = scanner.nextLine();
                        LocalDate fechaE2 = LocalDate.parse(textoFecha2, formatoEntrada);
                        System.out.print("Lugar del evento: ");
                        String lugarE2 = scanner.nextLine();
                        Evento eventoNuevo2 = new Evento(nombreE2, fechaE2, lugarE2);
                        eventosRegistrados.add(eventoNuevo2);
                        System.out.println("Evento \"" + nombreE2 + "\" creado (con lugar).");
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido. Use d/M/yyyy (ej.: 2/3/2023).");
                    }
                    break;

                case 3:
                    // Agregar invitados a un evento seleccionado
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println("No hay eventos registrados aún.");
                        break;
                    }
                    System.out.println("Seleccione el evento al que desea agregar invitados:");
                    for (int i = 0; i < eventosRegistrados.size(); i++) {
                        Evento ev = eventosRegistrados.get(i);
                        System.out.println((i + 1) + ". "
                                + ev.getNombreEvento() + " ("
                                + ev.getFechaEvento().format(formatoEntrada) + ")");
                    }
                    System.out.print("Número de evento: ");
                    int indiceEvento = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indiceEvento < 0 || indiceEvento >= eventosRegistrados.size()) {
                        System.out.println("Opción inválida.");
                    } else {
                        System.out.print("¿Agregar (1) un solo invitado o (2) varios invitados? Ingrese 1 o 2: ");
                        int tipoInv = scanner.nextInt();
                        scanner.nextLine();
                        if (tipoInv == 1) {
                            System.out.print("Nombre del invitado: ");
                            String nombreInv = scanner.nextLine();
                            eventosRegistrados
                                    .get(indiceEvento)
                                    .agregarInvitado(nombreInv);
                            System.out.println("Invitado \"" + nombreInv + "\" agregado.");
                        } else if (tipoInv == 2) {
                            System.out.println("Ingrese nombres de invitados separados por comas:");
                            String lineaInv = scanner.nextLine();
                            String[] arrInvitados = lineaInv.split(",");
                            List<String> listaNuevos = new ArrayList<>();
                            for (String inv : arrInvitados) {
                                listaNuevos.add(inv.trim());
                            }
                            eventosRegistrados
                                    .get(indiceEvento)
                                    .agregarListaInvitados(listaNuevos);
                            System.out.println("Invitados agregados.");
                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                    break;

                case 4:
                    // Mostrar todos los eventos
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println("No hay eventos registrados.");
                    } else {
                        System.out.println("\n--- LISTADO DE EVENTOS ---");
                        for (Evento e : eventosRegistrados) {
                            e.mostrarDetallesEvento();
                        }
                    }
                    break;

                case 5:
                    // Mostrar total de eventos creados
                    System.out.println("Total de eventos creados: " + Evento.obtenerTotalEventos());
                    break;

                case 6:
                    // Mostrar eventos por fecha
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println("No hay eventos registrados.");
                        break;
                    }
                    System.out.print("Ingrese la fecha a buscar (d/M/yyyy): ");
                    String textoFechaBuscar = scanner.nextLine();
                    try {
                        LocalDate fechaBuscar = LocalDate.parse(textoFechaBuscar, formatoEntrada);
                        boolean hallado = false;
                        System.out.println("Eventos en la fecha " + textoFechaBuscar + ":");
                        for (Evento ev : eventosRegistrados) {
                            if (ev.getFechaEvento().equals(fechaBuscar)) {
                                ev.mostrarDetallesEvento();
                                hallado = true;
                            }
                        }
                        if (!hallado) {
                            System.out.println("No se encontraron eventos en esa fecha.");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido. Use d/M/yyyy (ej.: 2/3/2023).");
                    }
                    break;

                case 7:
                    // Mostrar lista de lugares registrados (sin repetir)
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println("No hay eventos registrados.");
                        break;
                    }
                    System.out.println("Lugares de eventos registrados:");
                    ArrayList<String> lugaresUnicos = new ArrayList<>();
                    for (Evento ev : eventosRegistrados) {
                        String lugar = ev.getLugarEvento();
                        if (!lugaresUnicos.contains(lugar)) {
                            lugaresUnicos.add(lugar);
                        }
                    }
                    for (String lugar : lugaresUnicos) {
                        System.out.println("» " + lugar);
                    }
                    break;

                case 8:
                    // Mostrar eventos de un lugar específico
                    if (eventosRegistrados.isEmpty()) {
                        System.out.println("No hay eventos registrados.");
                        break;
                    }
                    System.out.print("Escriba el nombre exacto del lugar a buscar: ");
                    String lugarBuscado = scanner.nextLine();
                    boolean encontradoLugar = false;
                    for (Evento ev : eventosRegistrados) {
                        if (ev.getLugarEvento().equalsIgnoreCase(lugarBuscado.trim())) {
                            ev.mostrarDetallesEvento();
                            encontradoLugar = true;
                        }
                    }
                    if (!encontradoLugar) {
                        System.out.println("No se encontraron eventos en \"" + lugarBuscado + "\".");
                    }
                    break;

                case 0:
                    terminar = true;
                    System.out.println("Saliendo del gestor de eventos...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
