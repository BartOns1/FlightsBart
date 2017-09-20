package be.vdab.flights_passengers;

/*import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

*/

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vdabcursist on 12/09/2017.
 *//*

@Transactional
@Repository
public class FlightRespository {
    private List<Flight> flights = new ArrayList<>();

    @PersistenceContext
    private EntityManager em;


    public Flight readId(int id) {
        return em.find(Flight.class,id);//fake object for now
    }

    public void save(Flight f){
        em.persist(f);
    }

    public void deleteById(Integer id){
        Flight f  = em.getReference(Flight.class, id);
        em.remove(f);
    }

    public Flight queryByFlightNumber(String flightName){
        TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f WHERE f.flightName = :fn", Flight.class);
        query.setParameter("fn", flightName);
        return query.getSingleResult();
    }

}*/



public interface FlightRespository extends JpaRepository<Flight, Integer>{
    Flight readByFlightName(String flightName);
    Flight getByDepartureAndDestination(String departure, String destination);
    List<Flight> findAllByDestinationContaining(String internationalAnnotation);
      }