package cinema.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(String message) {
        super(message);
    }
}
