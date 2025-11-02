// @author Sebastian_Garcia
// @fecha 02/11/2025
// Descripción: Excepción personalizada que se tira cuando la búsqueda de dispositivo no se encuentra

public class DispositivoNoEncontradoException extends Exception {
    public DispositivoNoEncontradoException(String mensaje){
        super(mensaje); // mandar mensaje a la superclase Exception
    }
}
