// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que es el gestor principal del MODELO

import java.util.ArrayList;
import java.util.Collections;

public class FincaManager {

    // UNICA LISTA POLIMORFICA
    private ArrayList<Dispositivo> catalogoDispositivos;

    // CONSTRUCTOR
    public FincaManager() {
        this.catalogoDispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(Dispositivo d) {
        this.catalogoDispositivos.add(d);
    }

    // Cargar el catálogo inicial con al menos 10 equipos de naturaleza diversa
    public void cargarCatalogoInicial() {
        agregarDispositivo(new SensorSuelo(101, "Sensor Humedad 12 pro max", 5));
        agregarDispositivo(new SensorSuelo(102, "Sensor pH 13 pro max", 5));
        agregarDispositivo(new EstacionMeteorologica(201, "Estación Norte", 25));
        agregarDispositivo(new EstacionMeteorologica(202, "Estación Sur", 30));
        agregarDispositivo(new DronRiego(301, "Riego-Bot 15 air", 150));
        agregarDispositivo(new DronRiego(302, "Aqua-Dron 15 pro", 175));
        agregarDispositivo(new DronMonitoreo(401, "Agri-Scan 17 pro max", 200));
        agregarDispositivo(new DronMonitoreo(402, "Vigía MK-II 12", 220));
        agregarDispositivo(new SensorSuelo(103, "Sensor Temp 14 plus", 7));
        agregarDispositivo(new DronRiego(303, "Riego-Bot 17 pro", 120));
    }

    // Devuelve una lista de Strings con la información de todos los dispositivos
    public ArrayList<String> listarTodosLosEquipos() {
        ArrayList<String> reporte = new ArrayList<>();
        for (Dispositivo d : catalogoDispositivos) {
            reporte.add(d.toString());
        }
        return reporte;
    }

    // Buscar dispositivo por ID
    public Dispositivo buscarPorId(int id) throws DispositivoNoEncontradoException {
        for (Dispositivo d : catalogoDispositivos) {
            if (d.getId() == id) {
                return d;
            }
        }
        // Programación Defensiva
        throw new DispositivoNoEncontradoException("No se encontró ningún dispositivo con ID: " + id);
    }

    // Buscar dispositivo por su nombre
    public Dispositivo buscarPorNombre(String nombre) throws DispositivoNoEncontradoException {
        for (Dispositivo d : catalogoDispositivos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        // Programación Defensiva
        throw new DispositivoNoEncontradoException("No se encontró ningún dispositivo con NOMBRE: " + nombre);
    }

    // Ordenar el catálogo por consumo eléctrico usando Comparable
    public ArrayList<String> ordenarPorConsumo() {
        // Crear una copia de la lista para no modificar el original
        ArrayList<Dispositivo> copiaOrdenada = new ArrayList<>(this.catalogoDispositivos);
        
        // usar el comparable para ordenar la lista
        Collections.sort(copiaOrdenada);

        // Lista vacía que guarda los Strings
        ArrayList<String> reporteOrdenado = new ArrayList<>();
        
        for (Dispositivo d : copiaOrdenada) {
            reporteOrdenado.add(d.toString());
        }

        return reporteOrdenado;
    }
}
