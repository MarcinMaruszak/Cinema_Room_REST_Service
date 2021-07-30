package cinema.DTO;

import cinema.domain.Ticket;

import java.util.UUID;

public class TicketDTO {

    private UUID token;
    private Ticket ticket;

    public TicketDTO() {
    }

    public TicketDTO(UUID token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
