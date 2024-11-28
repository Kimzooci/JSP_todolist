package kyungseo.poc.todo.common.base;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javassist.bytecode.stackmap.TypeData.ClassName;

/**
 * GenericResponse 클래스
 * ResponseEntity를 생성하는 유틸리티 클래스
 */
@Component
public class GenericResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassName.class);

    public void someMethod() {
        LOGGER.info("Some informational message");
    }


    // Success Response 생성

    

    public static ResponseEntity<GenericResponseBody> success(String message) {
        return success(HttpStatus.OK, message, Collections.emptyList());
    }

    public static ResponseEntity<GenericResponseBody> success(String message, Object result) {
        return success(HttpStatus.OK, message, result);
    }

    public static ResponseEntity<GenericResponseBody> success(HttpStatus status, String message, Object result) {
        return ResponseEntity.ok(createSuccessBody(status, message, result));
    }

    // Fail Response 생성

    public static ResponseEntity<GenericResponseBody> fail(String message) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR, message, Collections.emptyList());
    }

    public static ResponseEntity<GenericResponseBody> fail(HttpStatus status, String message) {
        return fail(status, message, Collections.emptyList());
    }

    public static ResponseEntity<GenericResponseBody> fail(List<ObjectError> allErrors) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR, "Validation Error", allErrors);
    }

    public static ResponseEntity<GenericResponseBody> fail(HttpStatus status, String message, List<ObjectError> allErrors) {
        return ResponseEntity.ok(createErrorBody(status, message, allErrors));
    }

    // Body 생성 유틸리티

    private static GenericResponseBody createSuccessBody(HttpStatus status, String message, Object result) {
        return GenericResponseBody.builder()
                .state(status.value())
                .success(true)
                .message(message)
                .fieldErrors(StringUtils.EMPTY)
                .result(result)
                .timestamp(LocalDateTime.now())
                .build();
    }

    private static GenericResponseBody createErrorBody(HttpStatus status, String message, List<ObjectError> allErrors) {
        return GenericResponseBody.builder()
                .state(status.value())
                .success(false)
                .message(message)
                .fieldErrors(formatFieldErrors(allErrors))
                .result(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

    private static String formatFieldErrors(List<ObjectError> allErrors) {
        return allErrors.stream()
                .map(error -> {
                    if (error instanceof FieldError) {
                        FieldError fieldError = (FieldError) error;
                        return String.format("{\"field\":\"%s\",\"message\":\"%s\"}", fieldError.getField(), fieldError.getDefaultMessage().replace("\"", "'"));
                    } else {
                        return String.format("{\"object\":\"%s\",\"message\":\"%s\"}", error.getObjectName(), error.getDefaultMessage().replace("\"", "'"));
                    }
                })
                .collect(Collectors.joining(",", "[", "]"));
    }
}
