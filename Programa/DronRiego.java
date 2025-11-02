// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que representa un dron de riego

public class DronRiego extends Dispositivo implements Accionable, Registrable {
    
    // CONSTRUCTOR
    public DronRiego(int id, String nombre, int consumo){
        super(id, nombre, consumo);
    }

    @Override
    public boolean ejecutarAccion(String comando){ 
        if ("regar".equalsIgnoreCase(comando)) {
            System.out.println("Dron " + getNombre() + " iniciando ciclo de riego.");
            return true;
        }
        return false;
    }

    @Override
    public String logEvento(String evento){
        return "LOG [DronRiego " + getId() + "]: " + evento;
    }
}
