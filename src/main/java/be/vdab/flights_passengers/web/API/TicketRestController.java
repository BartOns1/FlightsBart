package be.vdab.flights_passengers.web.API;


import be.vdab.flights_passengers.TicketRepository2;
import be.vdab.flights_passengers.Ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by vdabcursist on 15/09/2017.
 */

@RestController
public class TicketRestController {
    @Autowired
    TicketRepository2 tr;

    @RequestMapping(method = RequestMethod.GET, path = "/api/ticket/all", produces ="application/json")
    public List<Ticket> allTickets() {
        return tr.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/ticket/{tid}", produces ="application/json")
    public Ticket getById(@PathVariable("tid") Integer id){
        return tr.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/ticket/del/all")
    public void deleteAllTickets() {
        tr.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/ticket/del/{tid}")
    public void deleteById(@PathVariable("tid") Integer id){
        tr.delete(id);
    }

}
