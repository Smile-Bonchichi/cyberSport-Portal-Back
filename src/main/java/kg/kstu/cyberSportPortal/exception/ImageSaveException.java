package kg.kstu.cyberSportPortal.exception;

import kg.kstu.cyberSportPortal.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class ImageSaveException extends BaseException {
    public ImageSaveException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
