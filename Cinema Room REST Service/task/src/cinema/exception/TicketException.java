package cinema.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class TicketException extends RuntimeException{

    public TicketException(String message) {
        super(message);
    }
}
