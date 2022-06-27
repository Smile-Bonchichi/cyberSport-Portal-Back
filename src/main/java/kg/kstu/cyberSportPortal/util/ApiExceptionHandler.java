package kg.kstu.cyberSportPortal.util;

import kg.kstu.cyberSportPortal.exception.base.BaseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<String> handleFailException(BaseException baseException) {
        return ResponseEntity
                .status(baseException.getHttpStatus())
                .body(baseException.getMessage());
    }
}
