package cinema.controller;

import cinema.DTO.AvailableSeatsDTO;
import cinema.DTO.ReturnTicketDTO;
import cinema.DTO.Stats;
import cinema.DTO.TicketDTO;
import cinema.domain.Seat;
import cinema.domain.Ticket;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping(path = "/seats")
    public @ResponseBody
    AvailableSeatsDTO getAvailableSeats() {
        return cinemaService.getAvailableSeats();
    }

    @PostMapping(path = "/purchase")
    public TicketDTO purchaseSeat(@RequestBody Seat seat) {
        return cinemaService.purchaseSeat(seat);
    }

    @PostMapping(path = "/return")
    public @ResponseBody
    ReturnTicketDTO returnTicket(@RequestBody TicketDTO ticketDTO){
        return cinemaService.returnTicket(ticketDTO);
    }

    @PostMapping(path = "/stats")
    public @ResponseBody
    Stats getStatistics(@RequestParam(required = false) String password){
        return cinemaService.getStatistics(password);
    }
}


