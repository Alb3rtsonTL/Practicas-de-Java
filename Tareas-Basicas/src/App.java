// import Tarea01_22_Ejercicios.Ejercicios; // Comentada porque no se usa
// import Tarea02_POO.MainTarea02; // Comentada porque no se usa
// import Tarea03_POO_Continuacion.MenuGeneral;
// import Tarea04_Sistema_AutoAlquiler.AgenciaAlquiler;
import Tarea05_Sis_Estudiantes_GestionMaterias_Notas.MenuGestion;

class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Cree un Package para poner cada practica con sus ejercicios dentro de su src correspondiente y después hago la llamada desde el método Main fuera del Package.");
        System.err.println("Para adelantarme un poco. \n");
        
        // Llamada al método principal de la clase para la tarea
        // Ejercicios.Ejercicio_01(); // Llamada al Ejercicios_01 de la tarea 01
        // MainTarea02.main(); // Llamada al main de la tarea 02 POO
        // MenuGeneral.MenuTarea03(); // Llamada al menu general de la tarea 03 POO Continuación

        // Instancia de MenuGestion para acceder a sus métodos
        MenuGestion menu = new MenuGestion();
        menu.menu();
    }
}