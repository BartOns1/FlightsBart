package be.vdab.flights_passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vdabcursist on 12/09/2017.
 */
@Service
public class TicketService {
  //  @Autowired
   /* TicketRespository tr;





*//*    public Ticket create(Flight f, double price, Passenger p){
        Ticket t = tr.persist(p, price,f);
        System.out.println("Ticket creation in TcketService:  " + t.toString());
        return t;
    }*//*

    public void addTicket(Ticket t){
         tr.save(t);
     }

     public Ticket findById(Integer id){
         return tr.readById(id);
     }*/

    @Autowired
    TicketRepository2 tr;

    public void  addTicket(Ticket t){
        tr.save(t);
    }

    public Ticket findById(Integer id){
        return tr.findOne(id);
    }

}
