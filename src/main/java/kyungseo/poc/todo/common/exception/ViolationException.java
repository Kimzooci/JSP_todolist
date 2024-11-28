
package kyungseo.poc.todo.common.exception;

public class ViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ViolationException() {
        super();
    }

    public ViolationException(String message) {
        super(message);
    }

    public ViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViolationException(Throwable cause) {
        super(cause);
    }

}
