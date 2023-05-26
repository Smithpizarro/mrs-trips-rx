package pe.business.app.strips.service;


import pe.business.app.strips.model.TripRq;
import pe.business.app.strips.model.TripRs;
import pe.business.app.strips.repository.entity.CityCount;
import pe.business.app.strips.repository.entity.CountryCount;
import pe.business.app.strips.repository.entity.TripCount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TripsService {

    public Flux<TripRs> getTrips(String typeFind, String status);
    public Mono<TripRs> saveTrip(TripRq tripRq) throws ExecutionException, InterruptedException;
    public Flux<TripRs> saveTripAll(List<TripRq> listTripRq) throws ExecutionException, InterruptedException;
    public Flux<CityCount> getTotalCityAll();
    public Flux<CountryCount> getTotalCountryAll();
    public Flux<TripCount> getTotalAll();
    public Mono<TripRs> updatedTrip(TripRq tripRq);

}
