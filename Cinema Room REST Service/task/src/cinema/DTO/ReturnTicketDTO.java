package cinema.DTO;

import cinema.domain.Ticket;

public class ReturnTicketDTO {
    private Ticket returned_ticket;

    public ReturnTicketDTO(Ticket returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public Ticket getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Ticket returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
