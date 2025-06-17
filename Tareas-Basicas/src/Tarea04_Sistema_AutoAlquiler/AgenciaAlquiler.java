package Tarea04_Sistema_AutoAlquiler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/* Clase AgenciaAlquiler que gestiona una colección de vehículos para alquilar.
 * Permite agregar, eliminar, alquilar y devolver vehículos, así como mostrar su información. */
public class AgenciaAlquiler {
    private ArrayList<Vehiculo> vehiculos;

    /* Constructor de la clase AgenciaAlquiler que inicializa la lista de vehículos. */
    public AgenciaAlquiler() { vehiculos = new ArrayList<>(); }

    /* Método para agregar un vehículo a la lista. */
    public void agregarVehiculo(Vehiculo v) { vehiculos.add(v); }

    /* Método para eliminar un vehículo de la lista por su matrícula. */
    public void eliminarVehiculo(String matricula) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                it.remove();
                System.out.println(" Vehículo retirado del sistema.");
                return;
            }
        }
        System.out.println(" No se encontró un vehículo con esa matrícula.");
    }

    /* Método para mostrar la información de todos los vehículos registrados. */
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println(" No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println("-----------------------------------------------");
            v.mostrarInformacion();
        }
    }

    /* Método para buscar un vehículo por su matrícula. */
    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }

    /*
     * Método que muestra el menú principal de la agencia de alquiler de vehículos.
     * Permite al usuario interactuar con las opciones disponibles.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Inicialización de vehículos de ejemplo
        Auto auto1 = new Auto("A1234", "Toyota", "Corolla", 2020, 4);
        Auto auto2 = new Auto("B5678", "Honda", "Civic", 2019, 2, "alquilado");
        Camioneta camioneta1 = new Camioneta("C9012", "Ford", "F-150", 2021, 1200.0);
        Camioneta camioneta2 = new Camioneta("D3456", "Chevrolet", "Silverado", 2022, 800.0, "alquilado");

        agregarVehiculo(auto1);
        agregarVehiculo(auto2);
        agregarVehiculo(camioneta1);
        agregarVehiculo(camioneta2);

        while (!salir) { // Menu principal
            System.out.println("\n-----------------------------------------------");
            System.out.println(" Menú Agencia de Alquiler de Vehículos");
            System.out.println("-----------------------------------------------");
            System.out.println(" 1. Agregar vehículo");
            System.out.println(" 2. Eliminar vehículo");
            System.out.println(" 3. Alquilar vehículo");
            System.out.println(" 4. Devolver vehículo");
            System.out.println(" 5. Mostrar información de vehículos");
            System.out.println(" 0. Salir");
            System.out.print(" [: Digite una opción\\> ");
            int opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1: // Agregar vehículo
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Agregar un nuevo vehiculo");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Tipo (1 = Auto, 2 = Camioneta): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(" Matrícula: ");
                    String mat = scanner.nextLine();
                    System.out.print(" Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print(" Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print(" Año: ");
                    int año = scanner.nextInt();
                    scanner.nextLine();

                    // Dependiendo del tipo de vehículo, se solicita información adicional
                    if (tipo == 1) {
                        System.out.print(" Número de puertas: ");
                        int puertas = scanner.nextInt();
                        scanner.nextLine();
                        agregarVehiculo(new Auto(mat, marca, modelo, año, puertas));
                        System.out.print("\n El auto ha sido agregado correctamente.\n");
                    } else if (tipo == 2) {
                        System.out.print(" Capacidad de carga (kg): ");
                        double cap = scanner.nextDouble();
                        scanner.nextLine();
                        agregarVehiculo(new Camioneta(mat, marca, modelo, año, cap));
                        System.out.print("\n La camioneta ha sido agregada correctamente.\n");
                    } else {
                        System.out.println("\n Tipo de vehículo elegido no está en el menú.\n");
                    }
                    break;

                case 2: // Eliminar vehículo
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Retirar un vehículo del sistema");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Ingrese matrícula a eliminar: ");
                    String matDel = scanner.nextLine();
                    eliminarVehiculo(matDel);
                    break;

                case 3: // Alquilar vehículo
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Alquilar un vehículo");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Ingrese matrícula a alquilar: ");
                    String matriculaAlquilada = scanner.nextLine();
                    Vehiculo vehiculoAlquilado = buscarVehiculo(matriculaAlquilada);
                    if (vehiculoAlquilado == null) { // Si no se encuentra el vehículo
                        System.out.println(" No hay un vehiculo con esa matricula.");
                    } else if (vehiculoAlquilado instanceof Camioneta) {
                        // Pregunta si se desea verificar la capacidad mínima antes de alquilar
                        System.out.print(" ¿Desea verificar capacidad mínima? (s/n): ");
                        String capacidadResp = scanner.nextLine();
                        if (capacidadResp.equalsIgnoreCase("s")) {
                            System.out.print(" Ingrese capacidad mínima requerida (kg): ");
                            double minimo = scanner.nextDouble();
                            scanner.nextLine();
                            boolean alquilerResp = ((Camioneta) vehiculoAlquilado).alquilar(minimo);
                            System.out.println(alquilerResp ? " Alquiler exitoso."
                                    : " No se puede alquilar (capacidad insuficiente o no disponible).");
                        } else {
                            boolean alquilerResp = ((Camioneta) vehiculoAlquilado).alquilar();
                            System.out.println(
                                    alquilerResp ? " Alquiler exitoso." : " No se puede alquilar (no disponible).");
                        }
                    } else if (vehiculoAlquilado instanceof Auto) {
                        boolean alquilerResp = ((Auto) vehiculoAlquilado).alquilar();
                        System.out.println(
                                alquilerResp ? " Alquiler exitoso." : " No se puede alquilar (no disponible).");
                    }
                    break;

                case 4: // Devolver vehículo
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Devolver un vehículo");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Ingrese matrícula a devolver: ");
                    String matriculaDevolver = scanner.nextLine();
                    Vehiculo vehiculoDevolver = buscarVehiculo(matriculaDevolver);
                    if (vehiculoDevolver == null) {
                        System.out.println(" No hay un vehiculo con esa matricula.");
                    } else if (vehiculoDevolver instanceof IAlquiler) {
                        ((IAlquiler) vehiculoDevolver).devolver();
                        System.out.println(" Vehículo devuelto.");
                    }
                    break;

                case 5: // Mostrar información de todos los vehículos
                    System.out.println("\n-----------------------------------------------");
                    System.out.println(" Mostrar información de todos los vehículos");
                    System.out.println("-----------------------------------------------");
                    mostrarVehiculos();
                    break;

                case 0: // Salgo del menú
                    salir = true;
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Saliendo del Menú general del sistema...");
                    break;

                default: // Si la opción no existe
                    System.out.println("-----------------------------------------------");
                    System.out.println(" La opción no existe en el menú..]\n");
                    break;
            }
        }
    }
}
