package kg.kstu.cyberSportPortal.exception;

import kg.kstu.cyberSportPortal.exception.base.BaseException;

import org.springframework.http.HttpStatus;

public class UserNotCorrectPasswordException extends BaseException {
    public UserNotCorrectPasswordException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
