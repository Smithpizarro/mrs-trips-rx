package pe.business.app.strips.controller.exception;

public class CustomParameterConstraintException extends RuntimeException {

    public CustomParameterConstraintException() {
        super();
    }

    public CustomParameterConstraintException(String message) {
        super(message);
    }
}