package be.vdab.flights_passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vdabcursist on 12/09/2017.
 */


@Service //= @Component + extra's vor service layer
public class PassengerService {
    @Autowired
    private PassengerRespository pr;

    public String getAll() {
        System.out.println("get all inside passenger service");
        return pr.findAll().toString();
    }


/*    public Passenger getPassengerById(int Id){
        return pr.readById(Id);
    }

    public void addPassenger(Passenger p){
        pr.save(p);
    }

    public void deletePassengerById(Integer id){
        pr.deleteById(id);
    }*/

    public Passenger getPassengerById(int id){
        return pr.findOne(id);
    }

    public void addPassenger(Passenger p){
        pr.save(p);
    }

    public void deletePassengerById(Integer id){
        pr.delete(id);
    }
//Om rechten en paswoorden te gebruiken gebruik je "Spring security"
}
