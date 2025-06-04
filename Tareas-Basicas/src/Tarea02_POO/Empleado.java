package Tarea02_POO;
/** Clase Empleado Descripción:
 * Entidad con atributos básicos de un empleado y con comportamientos 
 * específicos según diferentes roles en una empresa. */
class Empleado {
    private String nombre;
    private String apellidos;
    private int edad;
    private double sueldo;
    private String departamento;

    // Constructor que inicializa los atributos.
    public Empleado(String nombre, String apellidos, int edad, double sueldo, String depto) {
        this.nombre     = nombre;
        this.apellidos  = apellidos;
        this.edad       = edad;
        this.sueldo     = sueldo;
        this.departamento = depto;
    }

    // getters y setters para cada atributo.
    public String getNombre()            { return nombre; }
    public void   setNombre(String n)    { this.nombre = n; }
    
    public String getApellidos()         { return apellidos; }
    public void   setApellidos(String a) { this.apellidos = a; }
    
    public int    getEdad()              { return edad; }
    public void   setEdad(int e)         { this.edad = e; }
    
    public double getSueldo()            { return sueldo; }
    public void   setSueldo(double s)    { this.sueldo = s; }
    
    public String getDepartamento()      { return departamento; }
    public void   setDepartamento(String d) { this.departamento = d; }

    //#region Acciones
    // Acciones Gerente
    public void gestionar()   { System.out.println(nombre + " está gestionando recursos."); }
    public void planificar()  { System.out.println(nombre + " está planificando estrategias."); }
    public void supervisar()  { System.out.println(nombre + " está supervisando proyectos."); }

    // Acciones Programador
    public void desarrollar(){ System.out.println(nombre + " está escribiendo código."); }
    public void depurar()    { System.out.println(nombre + " está depurando errores."); }
    public void desplegar()  { System.out.println(nombre + " está desplegando la aplicación."); }

    // Acciones para Asistente de Servicios
    public void asistirClientes()    { System.out.println(nombre + " asiste a un cliente."); }
    public void resolverConsultas()  { System.out.println(nombre + " resuelve una consulta."); }
    public void tramitarReclamos()   { System.out.println(nombre + " tramita un reclamo."); }

    // Acciones para Vendedor
    public void vender()    { System.out.println(nombre + " está vendiendo productos."); }
    public void negociar()  { System.out.println(nombre + " está negociando términos."); }
    public void cerrarVenta(){ System.out.println(nombre + " cierra una venta."); }

    // Acciones para Analista
    public void analizarDatos()          { System.out.println(nombre + " analiza datos."); }
    public void generarReporte()         { System.out.println(nombre + " genera un reporte."); }
    public void recomendarEstrategias()  { System.out.println(nombre + " recomienda estrategias."); }
    //#endregion
}
