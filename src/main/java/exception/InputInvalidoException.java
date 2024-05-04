package exception;

public class InputInvalidoException extends RuntimeException {
    private String message;

    public InputInvalidoException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
