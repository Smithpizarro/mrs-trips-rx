package pe.business.app.strips.controller.exception;

public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    public ServiceException(String code) {
        super(code);
    }
}
