package cinema.domain;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private List<Seat> seats;

    public CinemaRoom() {
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    private CinemaRoom(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.seats = new ArrayList<>();
    }

    public static CinemaRoom createCinema(int rows, int columns) {
        CinemaRoom cinema = new CinemaRoom(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cinema.seats.add(new Seat(i + 1, j + 1, true, i < 4 ? 10 : 8));
            }
        }
        return cinema;
    }

}
