package be.vdab.flights_passengers;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdabcursist on 12/09/2017.
 */

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable = false)
    private String flightName;

    @Column(nullable=false)
    private String departure;

    @Column(nullable=false)
    private String destination;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<>();


    /**
     * Used by JPA.
     */
    Flight(){};

    public Flight(String flightName, String departure, String destination) {
        this.flightName = flightName;
        this.departure = departure;
        this.destination = destination;
    }


    public void addTicket(Ticket ticket){
        tickets.add(ticket);

    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    @Override
    public String toString() {
        return "flight " + flightName  + " Departure = " + departure + "  Destination = " + destination;
    }

    public Integer getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
