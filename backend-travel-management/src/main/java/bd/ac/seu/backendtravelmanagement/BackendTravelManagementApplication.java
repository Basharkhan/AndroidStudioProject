package bd.ac.seu.backendtravelmanagement;

import bd.ac.seu.backendtravelmanagement.Entity.Comment;
import bd.ac.seu.backendtravelmanagement.Entity.Trip;
import bd.ac.seu.backendtravelmanagement.Repository.CommentRepository;
import bd.ac.seu.backendtravelmanagement.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BackendTravelManagementApplication {
	@Autowired
	TripRepository tripRepository;
	@Autowired
	CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendTravelManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

/*
            Comment comment = new Comment("It was awesome place to visit.");
            commentRepository.save(comment);
*/
//			Trip trip = new Trip("Trip To Rajbari", "Dhaka", "Rajbari", "1-11-2020", "Bashar", "01966");
//			tripRepository.save(trip);
			List<Trip> tripList = tripRepository.findAll();
			tripList.forEach(System.out::println);
		};
	}
}
