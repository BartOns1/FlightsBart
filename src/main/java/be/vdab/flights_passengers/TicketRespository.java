package be.vdab.flights_passengers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vdabcursist on 12/09/2017.
 */
@Transactional
@Repository
public class TicketRespository {
    private List<Ticket> tickets = new ArrayList<>();

    @PersistenceContext
    private EntityManager em;

/*
    public Ticket persist(Passenger p, double price, Flight f){
        Ticket t = new Ticket(p,price,f);

        System.out.println("New ticket consolidation" + t.toString());
        return t;
    };
*/

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean addTicket(Ticket t){
        return tickets.add(t);
    }

    public void save(Ticket t){
        //door @Transactional van Spring org is dit "em.getTransaction().begin();" niet meer nodig
        em.persist(t);
    }

    public Ticket readById(Integer id){
        return em.find(Ticket.class,id);
    }

    public void deleteById(Integer id){
        Ticket t = em.getReference(Ticket.class, id);
        em.remove(t);
    }

}
