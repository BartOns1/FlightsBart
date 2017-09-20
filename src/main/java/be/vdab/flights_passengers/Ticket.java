package be.vdab.flights_passengers;

import javax.persistence.*;

/**
 * Created by vdabcursist on 12/09/2017.
 */
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "passenger_id")
    @ManyToOne
    private Passenger pass;

    private double price;

    @JoinColumn(nullable=false)
    @ManyToOne
    private Flight flight;



    /**
     * Used by JPA.
     */
    Ticket(){};

    public Ticket(Passenger p, double price, Flight f) {
        this.pass = p;
        this.price = price;
        this.flight = f;
    }

    public Passenger getPassenger() {
        return pass;
    }

    public void setPassenger(Passenger p) {
        this.pass = p;
        if (pass!=null){
        p.addTicket(this);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight f) {
        this.flight = f;
        pass.addTicket(this);
    }

    @Override
    public String toString() {
        return "Ticket: passenger " + pass + ", price = " + price + ", " + flight ;
    }
}