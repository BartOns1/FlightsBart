package be.vdab.flights_passengers;

/*import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

*/

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vdabcursist on 12/09/2017.
 *//*

@Transactional
@Repository  //meer dan alleen maar component; component + extras voor respisotory
public class PassengerRespository {

    @PersistenceContext
    private EntityManager em;



    public List<Passenger> findAll(){
        TypedQuery<Passenger> q = em.createQuery("SELECT p FROM Passenger p ORDER BY p.lastName", Passenger.class);
        return q.getResultList();
      }

    public Passenger readById(int id){
        return em.find(Passenger.class, id);
    }

    public void save(Passenger p){
       //door @Transactional van Spring org is dit "em.getTransaction().begin();" niet meer nodig
        em.persist(p);
    }

    public void deleteById(Integer id){
        Passenger p = em.getReference(Passenger.class, id);
        em.remove(p);
    }

}*/


public interface PassengerRespository extends JpaRepository<Passenger, Integer> {
    Passenger findByFirstNameAndLastName(String firstName, String lastName);

}