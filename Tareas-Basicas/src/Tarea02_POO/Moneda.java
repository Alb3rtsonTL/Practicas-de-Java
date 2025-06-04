package Tarea02_POO;

import java.util.Map;
import java.util.HashMap;

/** Clase Moneda Descripción:
 * Para representar la conversión entre diferentes monedas y realizar operaciones matemáticas entre ellas. */
class Moneda {
    private double valor;
    private String tipo;  // p.ej. "USD", "EUR", "JPY", "GBP"

    // tabla simple de tasas de conversión (1 USD = x OTRA)
    private static final Map<String,Double> aUSD = new HashMap<>();
    static {
        aUSD.put("USD", 1.0);
        aUSD.put("EUR", 1.18);   // 1 EUR = 1.18 USD
        aUSD.put("JPY", 0.0091); // 1 JPY = 0.0091 USD
        aUSD.put("GBP", 1.39);   // 1 GBP = 1.39 USD
    }

    public Moneda(double valor, String tipo) {
        this.valor = valor;
        this.tipo  = tipo;
    }
    public double getValor()   { return valor; }
    public String getTipo()    { return tipo; }

    // convierte el valor actual a la moneda destino
    public double convertir(String destino) {
        double enUSD = valor * aUSD.get(tipo);
        return enUSD / aUSD.get(destino);
    }
    // suma otra moneda (conversión si es distinto tipo)
    public Moneda agregar(Moneda otra) {
        double otraEnMiTipo = otra.valor * aUSD.get(otra.tipo) / aUSD.get(this.tipo);
        return new Moneda(this.valor + otraEnMiTipo, this.tipo);
    }
    // resta otra moneda
    public Moneda restar(Moneda otra) {
        double otraEnMiTipo = otra.valor * aUSD.get(otra.tipo) / aUSD.get(this.tipo);
        return new Moneda(this.valor - otraEnMiTipo, this.tipo);
    }
}
