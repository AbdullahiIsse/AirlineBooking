package server.model.database;

import shared.transferobjects.Seat;

import java.util.List;

public interface SeatDao {


    Seat getSeatId(int seatID,String seatNumber, String classType);
    Seat CreateSeat(String SeatNumber,String classtype);

    List<Seat> getSeat(int planeId);
    List<Seat> getSeats();
    List<Seat> countSeats();

    void deleteSeat(Seat seat);
}
