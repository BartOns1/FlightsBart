package be.vdab.flights_passengers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vdabcursist on 12/09/2017.
 */

@Entity
public class Passenger {

    @Column(nullable=false)
    String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    String lastName;

    @Column(name="BonusMyles")
    private int frequentFlyerMyles = 0;

    @OneToMany(mappedBy = "pass")//ander manier om in controller een passenger te deleten en dus de tickets is door cascade = CascadeType.REMOVE tussen de haakjes te zetten
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * Used by JPA.
     */
    Passenger(){};


    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
        if(!ticket.getPassenger().equals(this)){
            ticket.setPassenger(this);
        }
    }

    public Passenger(String firstName, String lastName, int frequentFlyerMyles) {
        this(firstName, lastName);
        this.frequentFlyerMyles=frequentFlyerMyles;
    }

    public Integer getId() {
        return id;
    }

    //@JsonIgnore  //nu zal deze getter niet meer laten zien voor de controller
    public int getFrequentFlyerMyles() {
        return frequentFlyerMyles;
    }

    public void setFrequentFlyerMyles(int fequentFlyerMyles) {
        this.frequentFlyerMyles = fequentFlyerMyles;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@JsonProperty("abc")//lastName wordt nu als abc gemarcheld
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String
    toString() {
        return fullName();
    }

    @JsonIgnore
    public List<Ticket> getTickets() {
        return tickets;
    }
}
