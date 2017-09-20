package be.vdab.flights_passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vdabcursist on 12/09/2017.
 */
@Service
public class FlightService {
    @Autowired
    FlightRespository fr;

    public Flight findById(Integer Id){
        return fr.findOne(Id);
    }

    public void persist(Flight f){
        fr.save(f);
    }

    public void DeleteById(Integer id){
        fr.delete(id);
    }
}
