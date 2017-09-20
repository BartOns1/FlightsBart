package be.vdab.flights_passengers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@SpringBootApplication
public class Application {
//een voorbeeld met een persistence (respository), service en presentation layer, maar de presentation layer ontbreekt en dedatabase is voorlopig vervangen door listings
	public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Application.class, args);

		PassengerRespository pr = ac.getBean(PassengerRespository.class);
		FlightRespository fr = ac.getBean(FlightRespository.class);
		TicketRepository2 tr = ac.getBean(TicketRepository2.class);

		ReservationService rs = ac.getBean(ReservationService.class);
		FlightService fs = ac.getBean(FlightService.class);
		PassengerService ps = ac.getBean(PassengerService.class);
		TicketService ts = ac.getBean(TicketService.class);

		Passenger p = new Passenger("Jimi","Hendrix", 157);
		pr.save(p);
		p = new Passenger("John","Postland", 157);
		pr.save(p);
		p = new Passenger("Aliondra","vintag", 157);
		pr.save(p);
		p = new Passenger("Bindokov","Alexindirg", 157);
		pr.save(p);
		p = new Passenger("The","Donn", 157);
		ps.addPassenger(p);


		Flight f = new Flight("AB546F","Brussel", "Wenen intl.");
		fr.save(f);
		f = new Flight("JKL2F","Brussel", "Amsterdam intl.");
		fr.save(f);
		f = new Flight("IKS55","Brussel", "Tokio");
		fr.save(f);
		f = new Flight("JET778","Charleroi", "Bonn");
        fs.persist(f);

      List<Passenger> plist= pr.findAll();

        for(Passenger ploop:plist){
          System.out.println(ploop.toString());
        }

		rs.bookTicketForFlight(p.getId(),550,f.getId());
        //Ticket t = ts.findById(101);
        //System.out.println(t);
        rs.bookTicketForFlight(p.getId(),550,f.getId()-1);
        rs.bookTicketForFlight(p.getId(),550,f.getId());

        Flight f1 = fr.readByFlightName("JKL2F");
        //Flight f1 = fr.readByFlightName("JKL2F");


        System.out.println(f1.toString());

        fr.findAllByDestinationContaining("intl.");

        int j = tr.countByPriceIsGreaterThan(400);
        System.out.println(j);
        int i = tr.countTicketByPassFirstNameIsLikeAndPassLastNameIsLike("The", "Donn");

        System.out.println(p.firstName + " " + p.lastName + " heeft " + i + " tickets.");
//rich_domain_model is de tegenpool van dit business model: respisotory-service-presentation layer







	}
}
