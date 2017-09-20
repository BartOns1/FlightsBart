package be.vdab.flights_passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by vdabcursist on 14/09/2017.
 */
@Controller
public class MyTicketController {

    @Autowired
    TicketRepository2 tr;

    @RequestMapping("tickets.html")
     public String myblaTickets(Map <String, Object> model){
        List<Ticket> ticketList = tr.findAll();
        model.put("flightTickets", ticketList);
        //todo
        return "myTicketList";
    }


//nu met REST API
/*    @RequestMapping(method = RequestMethod.GET, path = "/api/ticket/all", produces = "application/json")
    @ResponseBody
    public List<Ticket> allTickets(){
         return tr.findAll();
    }*/




}
