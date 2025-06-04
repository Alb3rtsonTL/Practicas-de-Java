package Tarea02_POO;
/** Clase Temporizador Descripción:
 * Temporizador que permita manejar un contador de tiempo con operaciones para iniciar, detener y reiniciar el temporizador. */
class Temporizador {
    private long iniciarTiempo;
    private long tiempoActual;
    private boolean encurso;

    public Temporizador() {
        this.tiempoActual = 0;
        this.encurso      = false;
    }
    // getters y setters
    public long getTiempoActual()           { return tiempoActual; }
    public void setTiempoActual(long t)     { this.tiempoActual = t; }

    public void iniciar() {
        if (!encurso) {
            iniciarTiempo = System.currentTimeMillis();
            encurso   = true;
            System.out.println("Temporizador iniciado.");
        }
    }
    public void detener() {
        if (encurso) {
            tiempoActual = System.currentTimeMillis() - iniciarTiempo;
            encurso = false;
            System.out.println("Temporizador detenido.");
        }
    }
    public void reiniciar() {
        iniciarTiempo     = 0;
        tiempoActual  = 0;
        encurso       = false;
        System.out.println("Temporizador reiniciado.");
    }
}
