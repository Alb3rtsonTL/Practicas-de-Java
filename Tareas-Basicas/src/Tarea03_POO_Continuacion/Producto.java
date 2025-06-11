package Tarea03_POO_Continuacion;
import java.text.DecimalFormat;

/**
 * Clase que representa un producto con sus datos y stock.
 * Permite registrar productos, incrementar stock, procesar ventas y mostrar detalles.
 */
public class Producto {
    private String nombreProducto;
    private double precioUnitario;
    private int cantidadProducto;
    private static int totalProductos = 0;
    private String descripcion;
    private String fechaVencimiento;

    // Constructor actualizado
    public Producto(String nombreProducto, double precioUnitario, String descripcion, String fechaVencimiento) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidadProducto = 0;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        totalProductos++;
    }

    // Constructor anterior para compatibilidad
    public Producto(String nombreProducto, double precioUnitario) {
        this(nombreProducto, precioUnitario, "", "");
    }

    // Getters para el nombre, precio, cantidad, descripción y fecha de vencimiento
    public String getNombreProducto() { return nombreProducto;}

    public double getPrecioUnitario() { return precioUnitario; }

    public int getCantidadProducto() { return cantidadProducto; }

    public String getDescripcion() { return descripcion; }

    public String getFechaVencimiento() { return fechaVencimiento; }

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
        System.out.println(" Descripción: " + descripcion);
        System.out.println(" Fecha de vencimiento: " + fechaVencimiento);
        System.out.println(" Precio unitario: $" + formatoPrecio.format(precioUnitario));
        System.out.println(" Stock disponible: " + cantidadProducto);
        System.out.println("-----------------------------------------------");
    }

    // Método estático que devuelve cuántos productos se han creado
    public static int obtenerTotalProductos() {
        return totalProductos;
    }
}
