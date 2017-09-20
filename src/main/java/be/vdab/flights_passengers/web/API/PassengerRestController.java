package be.vdab.flights_passengers.web.API;

import be.vdab.flights_passengers.Passenger;
import be.vdab.flights_passengers.PassengerRespository;

import be.vdab.flights_passengers.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vdabcursist on 15/09/2017.
 */
@RestController
//@RequestMapping("/api/passenger") kan je gebruiken om te voorkomen dat je dit stukt pad steeds opnieuw schrijven
public class PassengerRestController {

    @Autowired
    PassengerRespository pr;

    @RequestMapping(method = RequestMethod.GET, path = "/api/passenger/all", produces ="application/json")
    public List<Passenger> allPassengers() {
        return pr.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/passenger/{pid}", produces ="application/json")
    public Passenger getById(@PathVariable("pid") Integer id){
        return pr.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/passenger/all")
    public void deleteAllPassengers() {
        pr.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/passenger/{pid}")
    public void deletePassengerById(@PathVariable("pid") Integer id){
        pr.delete(id);

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/passenger/{pid}", produces = "application/json")
    public void deleteAllPassengersOption2(@PathVariable("pid") Integer id) {
        Passenger passenger = pr.findOne(id);
        for (Ticket ticket : passenger.getTickets()){
            ticket.setPassenger(null);
        }
        pr.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/passenger", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Passenger> create(@RequestBody Passenger input){
        if (input.getId()!= null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        pr.save(input);
        return new ResponseEntity<Passenger>(input, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/api/passenger", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Passenger> update(@RequestBody Passenger input){
        if(input.getId()==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            pr.save(input);
            return new ResponseEntity<>(input, HttpStatus.OK);
    }
//json file moet de velden hebben van de klassen. er wordt automatisch een get of set aan toegevoegd.
// Dus zeker niet de colom-namen van de tabellen


}
