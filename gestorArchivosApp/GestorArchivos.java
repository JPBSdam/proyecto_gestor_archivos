package gestorArchivosApp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gestorArchivosApp.utils.Lectores.*;

public class GestorArchivos {

    public static void mostrarDirectorios() {
        String userHome = System.getProperty("user.home");
        File carpetaUsuario = new File(userHome);
        File[] archivos = carpetaUsuario.listFiles();

        if (archivos != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("\nDirectorios en la carpeta del usuario:\n");

            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    String nombre = archivo.getName();
                    String fecha = sdf.format(new Date(archivo.lastModified()));
                    long tamanioKB = archivo.length() / 1024;

                    System.out.printf("Nombre: %-30s | Última modificación: %-20s | Tamaño: %d KB%n", nombre, fecha, tamanioKB);
                }
            }
        } else {
            System.out.println("No se pudo acceder a la carpeta del usuario.");
        }
    }

    public static File buscarArchivo(String nombreArchivo) {
        String ruta = System.getProperty("user.home") + File.separator + nombreArchivo;
        File archivo = new File(ruta);
        return archivo.exists() ? archivo : null;
    }

    public static void crearArchivoTexto() {

        String nombreArchivo = leerTexto("Introduce el nombre del archivo de texto (sin extensión): ") + ".txt";

        File archivo = buscarArchivo(nombreArchivo);

        if (archivo == null) {
            try {
                archivo = new File(System.getProperty("user.home") + File.separator + nombreArchivo);
                if (archivo.createNewFile()) {

                    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
                        writer.println(leerTexto("Introduce tu nombre en el archivo: "));
                        System.out.println("Archivo creado con éxito: " + archivo.getName());
                    }
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo " + nombreArchivo + " ya existe.");
        }
    }

    public static void mostrarContenidoArchivoTexto() {
        String nombreArchivo = leerTexto("Introduce el nombre del archivo (sin extensión): ") + ".txt";

        File archivo = buscarArchivo(nombreArchivo);

        if (archivo == null) {
            System.out.println("El archivo no existe.");
        } else {
            int contadorLineas = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                    contadorLineas++;
                }
                System.out.println("Número total de líneas: " + contadorLineas);
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    public static void editarArchivoTexto() {
        String nombreArchivo = leerTexto("Introduce el nombre del archivo a editar (sin extensión): ") + ".txt";

        File archivo = buscarArchivo(nombreArchivo);

        if (archivo == null) {
            System.out.println("El archivo no existe.");
        } else {
            try (FileWriter writer = new FileWriter(archivo, true); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                bufferedWriter.write(leerTexto("Introduce el texto que deseas añadir: "));

                System.out.println("Línea añadida correctamente.");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }

    public static void eliminarArchivoTexto() {
        String nombreArchivo = leerTexto("Introduce el nombre del archivo a eliminar (sin extensión): ") + ".txt";

        File archivo = buscarArchivo(nombreArchivo);

        if (archivo == null) {
            System.out.println("El archivo no existe.");
        } else {
            boolean confirmacion = leerBooleano("Seguro que desea eliminar el archivo " + nombreArchivo);
            if (confirmacion) {
                archivo.delete();
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.out.println("Archivo conservado.");
            }
        }
    }
}
