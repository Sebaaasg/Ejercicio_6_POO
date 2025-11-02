// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que conecta la vista con el modelo

import java.util.ArrayList;

public class Controlador {

    // ATRIBUTOS
    private FincaManager manager;
    private Vista vista;

    // CONSTRUCTOR
    public Controlador(FincaManager manager, Vista vista) {
        this.manager = manager;
        this.vista = vista;
    }

    public static void main(String[] args) {
        // crear instancias de modelo y vista
        FincaManager manager = new FincaManager();
        Vista vista = new Vista();
        
        // crear controlador y conectarlo
        Controlador controlador = new Controlador(manager, vista);
        
        controlador.iniciar();
    }

    public void iniciar() {
        // Cargar los datos iniciales en el modelo
        manager.cargarCatalogoInicial();
        vista.mostrarMensaje("BIENVENIDO AL SISTEMA DE AGRO-TECNOLOGÍA");
        
        boolean continuar = true;
        // BANDERA PARA EVITAR WHILE TRUE
        do {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    gestionarListarTodo();
                    break;
                case 2:
                    gestionarBuscar();
                    break;
                case 3:
                    gestionarOrdenarPorConsumo();
                    break;
                case 4:
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarError("Opción no válida. Por favor, intente de nuevo");
            }
        } while (continuar);
    }

    private void gestionarListarTodo() {
        ArrayList<String> lista = manager.listarTodosLosEquipos();
        vista.mostrarLista("Catálogo Completo de Dispositivos", lista);
    }

    // Gestionar submenu de busqueda
    private void gestionarBuscar() {
        int tipoBusqueda = vista.solicitarTipoBusqueda();
        try {
            Dispositivo encontrado;
            if (tipoBusqueda == 1) { // Buscar por ID
                String idStr = vista.solicitarTerminoBusqueda("ID");
                int id = Integer.parseInt(idStr); // Puede lanzar NumberFormatException
                encontrado = manager.buscarPorId(id); // Puede lanzar DispositivoNoEncontradoException
            } else { // Buscar por Nombre
                String nombre = vista.solicitarTerminoBusqueda("Nombre");
                encontrado = manager.buscarPorNombre(nombre); // Puede lanzar DispositivoNoEncontradoException
            }
            
            // Si todo sale bien, muestra el dispositivo
            vista.mostrarDispositivo(encontrado.toString());

        } catch (DispositivoNoEncontradoException e) {
            vista.mostrarError(e.getMessage());
        } catch (NumberFormatException e) {
            vista.mostrarError("El ID debe ser un número válido.");
        }
    }

    private void gestionarOrdenarPorConsumo() {
        ArrayList<String> listaOrdenada = manager.ordenarPorConsumo();
        vista.mostrarLista("Dispositivos Ordenados por Consumo (Menor a Mayor)", listaOrdenada);
    }
}
