
package kyungseo.poc.todo.common.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

}