package bd.ac.seu.backendtravelmanagement.Repository;

import bd.ac.seu.backendtravelmanagement.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, String>{
    Trip findTripById(String id);
    Trip findTripByTripName(String name);
}
