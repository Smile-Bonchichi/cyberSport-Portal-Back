package kg.kstu.cyberSportPortal.util;

import kg.kstu.cyberSportPortal.exception.base.BaseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Map<String, String>> handleFailException(BaseException baseException) {
        Map<String, String> error = new HashMap<>();
        error.put("message", baseException.getMessage());

        return ResponseEntity
                .status(baseException.getHttpStatus())
                .body(error);
    }
}
