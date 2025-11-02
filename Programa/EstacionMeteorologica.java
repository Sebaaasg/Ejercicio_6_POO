// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que representa una estacion meteorologica

public class EstacionMeteorologica extends Dispositivo implements Medible, Registrable {
    
    // CONSTRUCTOR
    public EstacionMeteorologica(int id, String nombre, int consumo){
        super(id, nombre, consumo);
    }

    @Override
    public String medir(){
        return "Estación " + getNombre() + " midiendo viento........... viento: 15 km/h, Temp: 22°C.";
    }

    @Override
    public String logEvento(String evento){
        return "LOG [Estacion " + getId() + "]: " + evento;
    }
}
