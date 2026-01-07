package gestorArchivosApp;

import static gestorArchivosApp.GestorArchivos.*;
import static gestorArchivosApp.utils.Lectores.*;


public class Principal {
    public static void main(String[] args) {

        bucleBasico();

    }

    public static void bucleBasico() {

        boolean salir = false;
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = leerEntero("Introduce un numero para elegir la opción: ");
            switch (opcion) {
                case 1:
                    mostrarDirectorios();
                    break;
                case 2:
                    crearArchivoTexto();
                    break;
                case 3:
                    mostrarContenidoArchivoTexto();
                    break;
                case 4:
                    editarArchivoTexto();
                    break;
                case 5:
                    eliminarArchivoTexto();
                    break;
                case 6:
                    System.out.println("Cerrando la aplicacion");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!salir);

    }

    public static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Mostrar directorios de la carpeta de usuario.");
        System.out.println("2. Crear un nuevo archivo de texto en la carpeta de usuario.");
        System.out.println("3. Mostrar el contenido de un archivo de texto de la carpeta de usuario.");
        System.out.println("4. Añadir una nueva línea de texto a un archivo de la carpeta de usuario.");
        System.out.println("5. Eliminar un archivo de la carpeta de usuario.");
        System.out.println("6. Salir.");
        System.out.print("Seleccione una opción: ");
    }
}
