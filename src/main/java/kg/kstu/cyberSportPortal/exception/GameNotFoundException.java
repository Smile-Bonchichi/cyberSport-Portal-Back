package kg.kstu.cyberSportPortal.exception;

import kg.kstu.cyberSportPortal.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class GameNotFoundException extends BaseException {
    public GameNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
