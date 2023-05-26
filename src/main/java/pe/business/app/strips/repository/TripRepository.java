package pe.business.app.strips.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pe.business.app.strips.repository.entity.CityCount;
import reactor.core.publisher.Flux;
import pe.business.app.strips.repository.entity.Trip;

import java.util.List;


@Repository
public interface TripRepository extends R2dbcRepository<Trip,Integer> {

  Flux<Trip> findByStatus(String status);

}
