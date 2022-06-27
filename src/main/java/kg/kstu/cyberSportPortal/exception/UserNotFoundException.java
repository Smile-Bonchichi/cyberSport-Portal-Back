package kg.kstu.cyberSportPortal.exception;

import kg.kstu.cyberSportPortal.exception.base.BaseException;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
