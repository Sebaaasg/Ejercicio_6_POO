// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Clase que representa un sensor de suelo

public class SensorSuelo extends Dispositivo implements Medible, Registrable {
    
    // CONSTRUCTOR
    public SensorSuelo(int id, String nombre, int consumo){
        super(id, nombre, consumo);
    }

    @Override
    public String medir(){
        return "SENSOR " + getNombre() + " midiendo humedad..... LA HUMEDAD ES DEL 35%";
    }

    @Override
    public String logEvento(String evento){
        return "LOG [SensorSuelo " + getId() + "] " + evento;
    }
}
