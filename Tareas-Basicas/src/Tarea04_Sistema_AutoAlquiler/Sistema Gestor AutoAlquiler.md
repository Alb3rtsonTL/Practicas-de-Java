Sistema de Gestión de Alquiler de Vehículos
1.	Crea la clase abstracta "Vehiculo":
o	Atributos: matrícula, marca, modelo, año y estado (indica si está "disponible" o "alquilado").

2.	Desarrolla dos clases hijas de "Vehiculo": "Auto" y "Camioneta":
o	Auto: Incluye un atributo adicional llamado "número de puertas".
o	Camioneta: Incorpora un atributo extra "capacidad de carga" (por ejemplo, en kilogramos).

3.	Define la interfaz "IAlquiler":
o	Métodos a declarar: alquilar y devolver.

4.	Implementa "IAlquiler" en las clases "Auto" y "Camioneta":
o	El método alquilar debe cambiar el estado del vehículo a "alquilado" verificando previamente que esté disponible.
o	El método devolver restablece el estado a "disponible" y realiza las acciones necesarias para la devolución.

5.	Sobrecarga el método alquilar en la clase "Camioneta":
o	Añade una versión del método que, además de verificar la disponibilidad, compruebe que la "capacidad de carga" cumpla con un umbral mínimo (por ejemplo, no permitir el alquiler si la capacidad es inferior a cierto valor).

6.	Crea la clase "AgenciaAlquiler":
o	Contendrá una lista de objetos de tipo "Vehiculo".
o	Métodos esenciales: agregar vehículo, eliminar vehículo y mostrar información detallada de todos los vehículos registrados.

7.	Implementa un menú interactivo en "AgenciaAlquiler":
o	Permite interactuar con los objetos de "Auto" y "Camioneta" ofreciendo opciones como:
	Alquilar vehículo
	Devolver vehículo
	Mostrar información de vehículos
	Salir del menú

8.	Utiliza la palabra reservada "super":
o	Empléala en "AgenciaAlquiler" (o en las clases hijas, cuando corresponda) para invocar métodos de la clase padre, especialmente al mostrar información general o reutilizar lógica común.

9.	Aplica sobrecarga de constructores y métodos:
o	Diseña constructores y métodos sobrecargados en las clases para que la creación e inicialización de objetos sea flexible y se adapte a distintos escenarios.
