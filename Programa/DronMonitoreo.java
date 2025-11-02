// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que representa un dron de monitoreo

public class DronMonitoreo extends Dispositivo implements Accionable, Registrable, Medible {

    // CONSTRUCTOR
    public DronMonitoreo(int id, String nombre, int consumo) {
        super(id, nombre, consumo);
    }

    @Override
    public boolean ejecutarAccion(String comando){
        if ("monitorear".equalsIgnoreCase(comando)) {
            System.out.println("Dron " + getNombre() + " iniciando barrido de imágenes.");
            return true;
        }
        return false;
    }

    @Override
    public String medir(){
        return "Dron " + getNombre() + " capturando imagen multiespectral.";
    }

    @Override
    public String logEvento(String evento){
        return "LOG [DronMonitoreo " + getId() + "]: " + evento;
    }
}
