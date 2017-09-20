package be.vdab.flights_passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vdabcursist on 12/09/2017.
 */
@Service
public class ReservationService {
    @Autowired
    FlightService fs;

    @Autowired
    TicketService ts;

    @Autowired
    PassengerService ps;

    public void bookTicketForFlight(int passengerId, double price, int flightId){
        Passenger p = ps.getPassengerById(passengerId);
        Flight f = fs.findById(flightId);
        ts.addTicket(new Ticket(p,price, f));
    }


}
