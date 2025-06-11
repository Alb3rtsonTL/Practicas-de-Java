package Tarea03_POO_Continuacion;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productosRegistrados = new ArrayList<>();
        boolean salir = false;

        // Inicializar algunos productos con descripción y fecha de vencimiento
        Producto producto1 = new Producto(
            "Diclofenac S 100 Blister",
            35.00,
            "Antiinflamatorio en blíster de 100mg",
            "31/12/2025"
        );
        producto1.incrementarStock(18);

        Producto producto2 = new Producto(
            "Acetaminofen MK Niños Suspension",
            800.00,
            "Suspensión para niños, 120ml",
            "15/11/2024"
        );
        producto2.incrementarStock(5);

        productosRegistrados.add(producto1);
        productosRegistrados.add(producto2);

        // Bucle del menú
        while (!salir) {
            System.out.println("---------------------------------------------------------------");
            System.out.println(" Gestión de Productos");
            System.out.println("---------------------------------------------------------------");
            System.out.println(" 1. Registrar nuevo producto");
            System.out.println(" 2. Agregar stock a un producto");
            System.out.println(" 3. Vender un producto");
            System.out.println(" 4. Mostrar todos los productos");
            System.out.println(" 5. Mostrar total de productos creados");
            System.out.println(" 0. Salir \n");
            System.out.print(" [: Digite una opción\\> ");
            int opSeleccionada = scanner.nextInt();
            scanner.nextLine();

            switch (opSeleccionada) {
                case 1:
                    // Registrar un nuevo producto
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Registrar nuevo producto");
                    System.out.println("---------------------------------------------------------------");
                    System.out.print(" Ingrese nombre del producto: ");
                    String nombreNuevo = scanner.nextLine();
                    System.out.print(" Ingrese precio unitario: ");
                    double precioNuevo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print(" Ingrese descripción del producto: ");
                    String descripcionNueva = scanner.nextLine();
                    System.out.print(" Ingrese fecha de vencimiento (dd/MM/yyyy): ");
                    String fechaVencimientoNueva = scanner.nextLine();
                    Producto productoNuevo = new Producto(nombreNuevo, precioNuevo, descripcionNueva, fechaVencimientoNueva);
                    productosRegistrados.add(productoNuevo);
                    System.out.println(" Producto \"" + nombreNuevo + "\" registrado correctamente.");
                    break;

                case 2:
                    // Agregar cantidad de un producto
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Agregar cantidad de un producto");
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Lista de productos:");
                    if (productosRegistrados.isEmpty()) {
                        System.out.println(" No hay productos registrados aún.");
                        break;
                    }
                    for (int i = 0; i < productosRegistrados.size(); i++) {
                        Producto p = productosRegistrados.get(i);
                        System.out.println((i + 1) + " . " + p.getNombreProducto()
                                + " (Cantidad: " + p.getCantidadProducto() + ")");
                    }
                    System.out.print(" Seleccione el número del producto al que desea agregar más cantidad: ");
                    int indiceAgregar = scanner.nextInt() - 1;
                    if (indiceAgregar < 0 || indiceAgregar >= productosRegistrados.size()) {
                        System.out.printf(" El producto %numeroProducto .", indiceAgregar);
                    } else {
                        System.out.print(" Cantidad a agregar: ");
                        int cantidadASumar = scanner.nextInt();
                        productosRegistrados
                                .get(indiceAgregar)
                                .incrementarStock(cantidadASumar);
                    }
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Lista de productos:");
                    System.out.println("---------------------------------------------------------------");
                    if (productosRegistrados.isEmpty()) {
                        System.out.println(" No hay productos registrados aún.");
                        break;
                    }
                    for (int i = 0; i < productosRegistrados.size(); i++) {
                        Producto p2 = productosRegistrados.get(i);
                        System.out.println((i + 1) + " . " + p2.getNombreProducto()
                                + " (Cantidad: " + p2.getCantidadProducto() + ")");
                    }
                    System.out.print(" Seleccione el número del producto a vender: ");
                    int indiceVender = scanner.nextInt() - 1;
                    if (indiceVender < 0 || indiceVender >= productosRegistrados.size()) {
                        System.out.println(" Opción invalida, la opción digitada no existe.\n");
                    } else {
                        System.out.print(" Cantidad a vender: ");
                        int cantidadAVender = scanner.nextInt();
                        productosRegistrados
                                .get(indiceVender)
                                .procesarVenta(cantidadAVender);
                    }
                    scanner.nextLine();
                    break;

                case 4:
                    // Paso la lista de todos los productos registrados
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Inventario de Productos");
                    System.out.println("---------------------------------------------------------------");
                    if (productosRegistrados.isEmpty()) {
                        System.out.println("  No hay productos registrados.");
                    } else {
                        for (Producto p : productosRegistrados) {
                            p.mostrarDetallesProducto();
                        }
                    }
                    break;

                case 5:
                    // Indico cuantos productos hay
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Total de productos en el sistema: " + Producto.obtenerTotalProductos());
                    break;

                case 0:
                    // Salgo del menú
                    salir = true;
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" Saliendo del sistema de productos...");
                    break;

                default:
                    // Si la opción no existe
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(" La opción no existe en el menú..]\n");
                    break;
            }
        }
    }
}
