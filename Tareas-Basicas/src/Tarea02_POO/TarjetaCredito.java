package Tarea02_POO;
/** Clase Tarjeta de Crédito Descripción:
 * Clase que modela el comportamiento de una tarjeta de crédito, 
 * permitiendo realizar operaciones comunes. */
class TarjetaCredito {
    private String numeroTarjeta;
    private double limiteCredito;
    private double creditoDisponible;

    public TarjetaCredito(String num, double limite) {
        this.numeroTarjeta      = num;
        this.limiteCredito      = limite;
        this.creditoDisponible  = limite;
    }
    // Getters y Setters
    public String getNumeroTarjeta()            { return numeroTarjeta; }
    public void   setNumeroTarjeta(String n)    { this.numeroTarjeta = n; }
    public double getLimiteCredito()            { return limiteCredito; }
    public void   setLimiteCredito(double l)    { 
        this.limiteCredito     = l;
        this.creditoDisponible = l; 
    }
    public double getCreditoDisponible()        { return creditoDisponible; }
    public void   setCreditoDisponible(double c){ this.creditoDisponible = c; }

    public void realizarCompra(double monto) {
        if (monto <= creditoDisponible) {
            creditoDisponible -= monto;
            System.out.printf("Compra de %.2f exitosa.\n", monto);
        } else {
            System.out.println("Saldo insuficiente para la compra de " + monto);
        }
    }
    public void pagarTarjeta(double monto) {
        creditoDisponible += monto;
        if (creditoDisponible > limiteCredito) {
            creditoDisponible = limiteCredito;
        }
        System.out.printf("Pago de %.2f recibido.\n", monto);
    }
    public double verificarLimite() {
        return creditoDisponible;
    }
}
