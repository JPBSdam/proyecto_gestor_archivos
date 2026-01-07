package gestorArchivosApp.utils;

import java.util.Scanner;

public class Lectores {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número decimal válido.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static boolean leerBooleano(String mensaje) {
        boolean resultado = false; // Se inicializa para evitar errores de compilación
        boolean entradaValida = false; // Controla si la entrada es válida

        while (!entradaValida) { // Sigue hasta que el usuario ingrese "s" o "n"
            System.out.print(mensaje + " (s/n): ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("s")) {
                resultado = true;
                entradaValida = true; // Marcamos que la entrada es válida
            } else if (entrada.equals("n")) {
                resultado = false;
                entradaValida = true; // Marcamos que la entrada es válida
            } else {
                System.out.println("Error: Ingresa 's' para sí o 'n' para no.");
            }
        }

        return resultado;
    }
}
