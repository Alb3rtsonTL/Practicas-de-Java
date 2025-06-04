package Tarea02_POO;

/** Clase Main Para arrancar las clases. */
public class Main {
    public static void main() throws InterruptedException {
        // 1. Empleados con Roles
        Empleado gerente       = new Empleado("Juan D.",    "García", 45, 85000, "Gerencia");
        Empleado programador   = new Empleado("Robert",   "Pérez",  30, 60000, "TI");
        Empleado asistente     = new Empleado("Alexandra",  "López",  28, 35000, "Atención al Cliente");
        Empleado vendedor      = new Empleado("Winifer", "Soto",   35, 40000, "Ventas");
        Empleado analista      = new Empleado("Wonifer",  "Ortega", 32, 55000, "Análisis");

        System.out.println(" Acciones de cada empleado ===::>");
        // Gerente
        gerente.gestionar();
        gerente.planificar();
        gerente.supervisar();
        // Programador
        programador.desarrollar();
        programador.depurar();
        programador.desplegar();
        // Asistente de servicio al cliente
        asistente.asistirClientes();
        asistente.resolverConsultas();
        asistente.tramitarReclamos();
        // Vendedor
        vendedor.vender();
        vendedor.negociar();
        vendedor.cerrarVenta();
        // Analista
        analista.analizarDatos();
        analista.generarReporte();
        analista.recomendarEstrategias();

        // 2. Tarjetas de Crédito
        TarjetaCredito tarjetaUno = new TarjetaCredito("1111-2222-3333-4444", 5000);
        TarjetaCredito tarjetaDos = new TarjetaCredito("5555-6666-7777-8888", 10000);
        TarjetaCredito tarjetaTres = new TarjetaCredito("9999-0000-1111-2222", 2000);

        System.out.println("\n Operaciones con tarjetas de crédito ===::>");
        tarjetaUno.realizarCompra(1200);
        tarjetaUno.realizarCompra(3000);
        System.out.printf("Límite disponible TC1: %.2f\n", tarjetaUno.verificarLimite());
        tarjetaUno.pagarTarjeta(1000);
        System.out.printf("Límite disponible TC1 tras pago: %.2f\n", tarjetaUno.verificarLimite());

        tarjetaDos.realizarCompra(2500);
        tarjetaDos.pagarTarjeta(500);
        System.out.printf("Límite disponible TC2: %.2f\n", tarjetaDos.verificarLimite());

        tarjetaTres.realizarCompra(1800);
        System.out.printf("Límite disponible TC3: %.2f\n", tarjetaTres.verificarLimite());
        tarjetaTres.pagarTarjeta(500);
        System.out.printf("Límite disponible TC3 tras pago: %.2f\n", tarjetaTres.verificarLimite());

        // 3. Temporizadores
        Temporizador temporizadorUno = new Temporizador();
        Temporizador temporizadorDos = new Temporizador();

        System.out.println("\n Probando temporizadores ===::>");
        temporizadorUno.iniciar();
        Thread.sleep(500);
        temporizadorUno.detener();
        System.out.printf("Tiempo transcurrido temporizador uno: %d ms\n", temporizadorUno.getTiempoActual());
        temporizadorUno.reiniciar();
        System.out.printf("Tiempo después de reiniciar temporizador uno: %d ms\n", temporizadorUno.getTiempoActual());

        temporizadorDos.iniciar();
        Thread.sleep(200);
        temporizadorDos.detener();
        System.out.printf("Tiempo transcurrido temporizador dos: %d ms\n", temporizadorDos.getTiempoActual());

        // 4. Película
        Pelicula pelicula = new Pelicula("Inception", "Christopher Nolan", true);
        System.out.println("\n Estado de la película ===::>");
        System.out.println(pelicula);
        pelicula.alquilar();
        System.out.println("Tras alquilar: " + pelicula);
        pelicula.devolver();
        System.out.println("Tras devolver: " + pelicula);

        // 5. Monedas
        System.out.println("\n Conversión y operaciones con monedas ===::>");
        Moneda moneda1 = new Moneda(100, "USD");
        Moneda moneda2 = new Moneda(85,  "EUR");
        Moneda moneda3 = new Moneda(1000,"JPY");
        Moneda moneda4 = new Moneda(75,  "GBP");
        Moneda moneda5 = new Moneda(200, "USD");
        Moneda moneda6 = new Moneda(50,  "EUR");
        Moneda moneda7 = new Moneda(500, "JPY");
        Moneda moneda8 = new Moneda(30,  "GBP");

        // Conversión
        System.out.printf("100 USD a EUR: %.2f EUR\n", moneda1.convertir("EUR"));
        System.out.printf("85 EUR a USD:  %.2f USD\n", moneda2.convertir("USD"));
        // Suma y resta (misma divisa)
        Moneda sumaUSD = moneda1.agregar(moneda5);
        System.out.printf("100 USD + 200 USD = %.2f USD\n", sumaUSD.getValor());
        Moneda restaEUR = moneda2.restar(moneda6);
        System.out.printf("85 EUR - 50 EUR = %.2f EUR\n", restaEUR.getValor());

        // 6. Matriz de Números Complejos
        System.out.println("\n=== Operaciones con matrices de números complejos ===::>");
        // Defino dos matrices 2x2
        MatrizCompleja mcUNO = new MatrizCompleja(2,2);
        MatrizCompleja mcDOS = new MatrizCompleja(2,2);

        // Primera matriz completa
        mcUNO.asignar(0,0, new NumeroComplejo(1,2));
        mcUNO.asignar(0,1, new NumeroComplejo(3,4));
        mcUNO.asignar(1,0, new NumeroComplejo(5,6));
        mcUNO.asignar(1,1, new NumeroComplejo(7,8));

        // Segunda matriz completa
        mcDOS.asignar(0,0, new NumeroComplejo(2,-1));
        mcDOS.asignar(0,1, new NumeroComplejo(0,1));
        mcDOS.asignar(1,0, new NumeroComplejo(1,0));
        mcDOS.asignar(1,1, new NumeroComplejo(4,-3));

        System.out.println("Matriz Uno:");
        mcUNO.imprimir();
        System.out.println("Matriz Dos:");
        mcDOS.imprimir();

        MatrizCompleja mcSuma = mcUNO.sumar(mcDOS);
        System.out.println("Matriz Uno + Matriz Dos:");
        mcSuma.imprimir();

        MatrizCompleja mcMultiplicada = mcUNO.multiplicar(mcDOS);
        System.out.println("Matriz Uno × Matriz Dos:");
        mcMultiplicada.imprimir();
    }
}