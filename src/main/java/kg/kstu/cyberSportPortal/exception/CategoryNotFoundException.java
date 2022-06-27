package kg.kstu.cyberSportPortal.exception;

import kg.kstu.cyberSportPortal.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends BaseException {
    public CategoryNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
