package cinema.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Seat {
    private int row;
    private int column;

    @JsonIgnore
    private boolean available;

    private int price;

    public Seat() {
    }

    public Seat(int row, int column, boolean available, int price) {
        this.row = row;
        this.column = column;
        this.available = available;
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
