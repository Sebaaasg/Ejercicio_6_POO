// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Excepción personalizada que se tira cuando la búsqueda de dispositivo no se encuentra

public abstract class Dispositivo implements Comparable<Dispositivo> {
    
    // ATRIBUTOS
    private int id, consumoElectrico;
    private String nombre;

    // CONSTRUCTOR
    public Dispositivo(int id, String nombre, int consumo){
        this.id = id;
        this.nombre = nombre;
        this.consumoElectrico = consumo;
    }

    // GETTERS
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getConsumoElectrico(){
        return consumoElectrico;
    }

    // Override para mostrar la información del dispositivo
    @Override
    public String toString(){
        return String.format("ID: %-4d | TIPO: %-22s | NOMBRE: %-20s | CONSUMO: %d W", this.id, this.getClass().getSimpleName(), this.nombre, this.consumoElectrico);
    }

    // Compara este dispositivo con otro respecto al consumo electrico, para poder usar Collections.sort() de forma auto
    @Override
    public int compareTo(Dispositivo otro){
        // ayuda a comparar enteros
        return Integer.compare(this.consumoElectrico, otro.consumoElectrico);
    }

}
