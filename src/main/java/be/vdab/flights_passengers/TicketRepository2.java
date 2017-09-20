package be.vdab.flights_passengers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vdabcursist on 14/09/2017.
 */
public interface TicketRepository2 extends JpaRepository<Ticket, Integer>{
    List<Ticket> findByPriceIsGreaterThanOrderByPrice(double bound);
    int countByPriceIsGreaterThan(double bound);
    int countTicketByPassFirstNameIsLikeAndPassLastNameIsLike(String firstName, String lastName);//niet de klasse Passenger maat veld Pass in Ticket
 }
//"SELECT o FROM Order o WHERE o.customer.address.zipcode = zipcode OR o.customer.name = name AND o.customer.address.state = state, Order.class"
//  List<Ticket> findByCustomerAddressZipcodeOrCustomerNameAndCustomerAddressState(String zipcode ,String  name, String state);
