package kyungseo.poc.todo.common.base;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GenericResponseBody {

    private int state;
    private boolean success;
    private String message;
    private String fieldErrors;
    private Object result;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    // 기본 생성자
    public GenericResponseBody() {}

    // 모든 필드를 포함하는 생성자
    public GenericResponseBody(int state, boolean success, String message, String fieldErrors, Object result, LocalDateTime timestamp) {
        this.state = state;
        this.success = success;
        this.message = message;
        this.fieldErrors = fieldErrors;
        this.result = result;
        this.timestamp = timestamp;
    }

    // Getter and Setter
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(String fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Builder 메서드 추가
    public static GenericResponseBody builder() {
        return new GenericResponseBody();
    }

    public GenericResponseBody state(int state) {
        this.state = state;
        return this;
    }

    public GenericResponseBody success(boolean success) {
        this.success = success;
        return this;
    }

    public GenericResponseBody message(String message) {
        this.message = message;
        return this;
    }

    public GenericResponseBody fieldErrors(String fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }

    public GenericResponseBody result(Object result) {
        this.result = result;
        return this;
    }

    public GenericResponseBody timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public GenericResponseBody build() {
        return this;
    }
}
