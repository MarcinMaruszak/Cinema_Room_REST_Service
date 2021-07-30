package cinema.service;

import cinema.DTO.AvailableSeatsDTO;
import cinema.DTO.ReturnTicketDTO;
import cinema.DTO.Stats;
import cinema.DTO.TicketDTO;
import cinema.domain.CinemaRoom;
import cinema.domain.Seat;
import cinema.domain.Ticket;
import cinema.exception.TicketException;
import cinema.exception.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    CinemaRoom cinemaRoom = CinemaRoom.createCinema(9, 9);
    Map<UUID, Ticket> soldTickets = new HashMap<>();

    public AvailableSeatsDTO getAvailableSeats() {
        List<Seat> availableSeats = cinemaRoom.getSeats().stream()
                .filter(Seat::isAvailable).collect(Collectors.toList());
        return new AvailableSeatsDTO(cinemaRoom.getTotalRows(), cinemaRoom.getTotalColumns(), availableSeats);
    }

    public TicketDTO purchaseSeat(Seat seatToReserve) {
        if (seatToReserve.getRow() > cinemaRoom.getTotalRows()
                || seatToReserve.getColumn() > cinemaRoom.getTotalColumns()
                || seatToReserve.getRow() < 1
                || seatToReserve.getColumn() < 1) {
            throw new TicketException("The number of a row or a column is out of bounds!");
        }

        Seat seat = cinemaRoom.getSeats().get((seatToReserve.getRow() - 1) * 9 + seatToReserve.getColumn() - 1);
        if (!seat.isAvailable()) {
            throw new TicketException("The ticket has been already purchased!");
        }
        seat.setAvailable(false);
        Ticket ticket = new Ticket(seat.getRow(), seat.getColumn(), seat.getPrice());
        UUID uuid = UUID.randomUUID();
        soldTickets.put(uuid, ticket);
        return new TicketDTO(uuid, ticket);
    }


    public ReturnTicketDTO returnTicket(TicketDTO ticketDTO) {
        Ticket ticket = soldTickets.get(ticketDTO.getToken());
        if(ticket == null){
            throw new TicketException("Wrong token!");
        }
        cinemaRoom.getSeats().get((ticket.getRow() - 1)  * 9 + ticket.getColumn() - 1).setAvailable(true);
        soldTickets.remove(ticketDTO.getToken());
        return new ReturnTicketDTO(ticket);
    }

    public Stats getStatistics(String password) {
        if(password == null || !password.equals("super_secret")){
            throw new WrongPasswordException("The password is wrong!");
        }
        int income = soldTickets.values().stream().mapToInt(Ticket::getPrice).sum();
        int availableSeats = (int) cinemaRoom.getSeats().stream().filter(Seat::isAvailable).count();
        int purchasedTickets = soldTickets.size();
        return new Stats(income, availableSeats, purchasedTickets);
    }

}
