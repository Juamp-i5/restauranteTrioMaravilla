package excepciones;

public class ListaVaciaException extends Exception {

    public ListaVaciaException() {
    }

    public ListaVaciaException(String message) {
        super(message);
    }

    public ListaVaciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
