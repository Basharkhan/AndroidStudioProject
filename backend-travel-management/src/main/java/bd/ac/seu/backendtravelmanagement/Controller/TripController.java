package bd.ac.seu.backendtravelmanagement.Controller;

import bd.ac.seu.backendtravelmanagement.Entity.Trip;
import bd.ac.seu.backendtravelmanagement.Repository.TripRepository;
import bd.ac.seu.backendtravelmanagement.TripResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    TripRepository tripRepository;

    @RequestMapping(path = "/trips")
    public List<Trip> getAllTrip(){
        return tripRepository.findAll();
    }

    @RequestMapping(path = "/addTrip", method = RequestMethod.POST)
    public TripResponse addTrip(@RequestBody Trip trip){
        tripRepository.save(trip);
        return new TripResponse(HttpStatus.OK.value(), "Submitted");
/*
        if(tripRepository.save(trip).getId() > 0){
            return new TripResponse(HttpStatus.OK.value(), "Submitted");
        }
        return new TripResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed");
*/
    }

    @RequestMapping(path = "/deleteTrip/{id}", method = RequestMethod.DELETE)
    public TripResponse deleteTrip(@PathVariable String id){
        Trip trip = tripRepository.findTripById(id);
        System.out.println("Deleted Trip: " + trip);
        tripRepository.delete(trip);
        return new TripResponse(HttpStatus.OK.value(), "Deleted from trip");
    }
}
