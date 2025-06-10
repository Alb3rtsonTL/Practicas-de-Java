package Tarea03_POO_Continuacion;

import java.text.DecimalFormat;

public class Producto {
    private String nombreProducto;
    private double precioUnitario;
    private int cantidadProducto;
    private static int totalProductos = 0;

    // Constructor que recibe nombreProducto y precioUnitario; cantidadProducto
    // inicia en 0.
    public Producto(String nombreProducto, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidadProducto = 0;
        totalProductos++;
    }

    // Getters para el nombre, precio y cantidad del producto
    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    // Método para incrementar el stock
    public void incrementarStock(int cantidadAgregar) {
        if (cantidadAgregar > 0) {
            this.cantidadProducto += cantidadAgregar;
            System.out.println(" " + cantidadAgregar + " unidades agregadas a \"" + nombreProducto + "\".");
        } else {
            System.out.println(" La cantidad a agregar debe ser mayor que cero.");
        }
    }

    // Método para procesar venta (reducir stock)
    public void procesarVenta(int cantidadVender) {
        if (cantidadVender <= 0) {
            System.out.println(" La cantidad a vender debe ser mayor que cero.");
        } else if (cantidadVender > this.cantidadProducto) {
            System.out.println(" No hay suficiente stock para vender " + cantidadVender
                    + " unidades de \"" + nombreProducto + "\".");
        } else {
            this.cantidadProducto -= cantidadVender;
            System.out.println(" Se vendieron " + cantidadVender + " unidades de \"" + nombreProducto + "\".");
        }
    }

    // Método para mostrar todos los datos del producto
    public void mostrarDetallesProducto() {
        DecimalFormat formatoPrecio = new DecimalFormat("#,##0.00");
        System.out.println(" Producto: " + nombreProducto);
        System.out.println(" Precio unitario: $" + formatoPrecio.format(precioUnitario));
        System.out.println(" Stock disponible: " + cantidadProducto);
        System.out.println("---------------------------------------------------------------");
    }

    // Método estático que devuelve cuántos productos se han creado
    public static int obtenerTotalProductos() {
        return totalProductos;
    }
}
