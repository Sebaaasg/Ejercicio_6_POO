// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que se encarga de la interacción con el usuario

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

    // ATRIBUTOS
    private Scanner scanner;

    // CONSTRUCTOR
    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    // MENU PRINCIPAL
    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Finca Agro-Tecnológica ---");
        System.out.println("1. Listar todos los dispositivos");
        System.out.println("2. Buscar dispositivo");
        System.out.println("3. Listar dispositivos ordenados por consumo de energía");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Manejo de error si el usuario no ingresa un número
            opcion = -1;
        } finally {
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
        return opcion;
    }

    // SUBMENU PARA BUSQUEDA
    public int solicitarTipoBusqueda() {
        int opcion = -1;
        do {
            System.out.println("  ¿Cómo desea buscar?");
            System.out.println("  1. Por ID");
            System.out.println("  2. Por Nombre");
            System.out.print("  Opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcion = -1;
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
            if (opcion != 1 && opcion != 2) {
                mostrarError("Por favor, seleccione 1 o 2.");
            }
        } while (opcion != 1 && opcion != 2);
        return opcion;
    }

    // Buscar por ID o nombre
    public String solicitarTerminoBusqueda(String tipo) {
        System.out.print("Ingrese el " + tipo + " a buscar: ");
        return scanner.nextLine();
    }

    
    public void mostrarLista(String titulo, ArrayList<String> lista) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("No hay dispositivos para mostrar");
        } else {
            for (String item : lista) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------------------");
    }

    // Muestra la info de un solo dispositivo
    public void mostrarDispositivo(String infoDispositivo) {
        System.out.println("\n--- Dispositivo Encontrado ---");
        System.out.println(infoDispositivo);
        System.out.println("---------------------------------");
    }

    public void mostrarError(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
