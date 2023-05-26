package pe.business.app.strips.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import pe.business.app.strips.model.*;
import pe.business.app.strips.repository.TripRepository;
import pe.business.app.strips.repository.entity.CityCount;
import pe.business.app.strips.repository.entity.CountryCount;
import pe.business.app.strips.repository.entity.Trip;
import pe.business.app.strips.repository.entity.TripCount;
import pe.business.app.strips.util.Constant;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class TripsServiceImpl implements TripsService {


    @Autowired
    TripRepository tripRepository;

    @Autowired
    DatabaseClient databaseClient;

    @Override
    public Flux<TripRs> getTrips(String typeFind, String status) {


        Flux<Trip> tripList = null;
        if (typeFind.equals(Constant.FIND_ALL))
            tripList = tripRepository.findAll();
        else {
            tripList = tripRepository.findByStatus(status);
        }


        return    tripList.map(
                  trip -> {
                      TripRs tripRs = new TripRs();
                      tripRs.setId(trip.getId());

                      AddressRs startRs = new AddressRs();
                      startRs.setPickup_address(trip.getStartAddress());
                      Dates date = new Dates();
                      date.$date=(trip.getStartDate());
                      startRs.setDate(date);
                      LocationRs locationRs = new LocationRs();
                      locationRs.setType(trip.getStartType());
                      String[] coordinates = trip.getStartCoordinates().split(",");
                      locationRs.setCoordinates(coordinates);
                      startRs.setPickup_location(locationRs);

                      AddressRs endRs = new AddressRs();
                      endRs.setPickup_address(trip.getEndAddress());
                      date.$date=(trip.getEndDate());
                      endRs.setDate(date);
                      locationRs.setType(trip.getEndType());
                      String[] coordinates2 = trip.getEndCoordinates().split(",");
                      locationRs.setCoordinates(coordinates2);
                      endRs.setPickup_location(locationRs);

                      tripRs.setStart(startRs);
                      tripRs.setEnd(endRs);
                      tripRs.setCountry(trip.getCountry());
                      tripRs.setCity(trip.getCity());
                      tripRs.setPassenger(trip.getCountry());
                      tripRs.setDriver(trip.getDriver());
                      tripRs.setCar(trip.getCar());
                      tripRs.setStatus(trip.getStatus());
                      tripRs.setCheck_code(trip.getCheckCode());
                      tripRs.setPrice(trip.getPrice());
                      return tripRs;
                  }

            );
    }


    @Override
    public Mono<TripRs> saveTrip(TripRq tripRq) throws ExecutionException, InterruptedException {

        TripRs tripRs = new TripRs();

        Trip trip = new Trip();
        trip.setStartAddress(tripRq.getStart().getPickup_address());
        trip.setStartDate(tripRq.getStart().getDate().$date);
        trip.setStartType(tripRq.getStart().getPickup_location().getType());
        trip.setStartCoordinates(tripRq.getStart().getPickup_location().getCoordinates()[0] +
                                "," + tripRq.getStart().getPickup_location().getCoordinates()[1]);

        trip.setEndAddress(tripRq.getEnd().getPickup_address());
        trip.setEndDate(tripRq.getEnd().getDate()!=null ? tripRq.getEnd().getDate().$date:null);
        trip.setEndType(tripRq.getEnd().getPickup_location().getType());
        trip.setEndCoordinates(tripRq.getEnd().getPickup_location().getCoordinates()[0] +
                "," + tripRq.getEnd().getPickup_location().getCoordinates()[1]);

        trip.setCountry(tripRq.getCountry().getName());
        trip.setCity(tripRq.getCity().getName());
        trip.setPassenger(tripRq.getPassenger().getFirst_name()+" "+tripRq.getPassenger().getLast_name());
        trip.setDriver(tripRq.getDriver().getFirst_name()+" "+ tripRq.getDriver().getLast_name());
        trip.setCar(tripRq.getCar().getPlate());
        trip.setStatus(tripRq.getStatus());
        trip.setCheckCode(tripRq.getCheck_code());
        trip.setPrice(tripRq.getPrice());

        //BeanUtils.copyProperties(studentRq,student);
        return  tripRepository.save(trip).map(
         trip1 -> {
                    tripRs.setId(trip1.getId());
                    tripRs.setStart(tripRq.getStart());
                    tripRs.setEnd(tripRq.getEnd());
                    tripRs.setCountry(tripRq.getCountry().getName());
                    tripRs.setCity(tripRq.getCity().getName());
                    tripRs.setPassenger(trip1.getPassenger());
                    tripRs.setDriver(trip1.getDriver());
                    tripRs.setCar(trip1.getCar());
                    tripRs.setStatus(trip1.getStatus());
                    tripRs.setCheck_code(tripRq.getCheck_code());
                    tripRs.setPrice(tripRq.getPrice());
                    return tripRs;
                }
        );


    }

    @Override
    public Mono<TripRs> updatedTrip(TripRq tripRq)  {


        TripRs tripRs = new TripRs();
        Trip trip = new Trip();

        tripRepository.findById(tripRq.getId()).doOnNext(
        trip1 -> {
            if(trip1==null){
                throw  new RuntimeException("nombre vacio");
            }
        }
        );
        trip.setId(tripRq.getId());
        trip.setStartAddress(tripRq.getStart().getPickup_address());
        trip.setStartDate(tripRq.getStart().getDate().$date);
        trip.setStartType(tripRq.getStart().getPickup_location().getType());
        trip.setStartCoordinates(tripRq.getStart().getPickup_location().getCoordinates()[0] +
                "," + tripRq.getStart().getPickup_location().getCoordinates()[1]);

        trip.setEndAddress(tripRq.getEnd().getPickup_address());
        trip.setEndDate(tripRq.getEnd().getDate()!=null ? tripRq.getEnd().getDate().$date:null);
        trip.setEndType(tripRq.getEnd().getPickup_location().getType());
        trip.setEndCoordinates(tripRq.getEnd().getPickup_location().getCoordinates()[0] +
                "," + tripRq.getEnd().getPickup_location().getCoordinates()[1]);

        trip.setCountry(tripRq.getCountry().getName());
        trip.setCity(tripRq.getCity().getName());
        trip.setPassenger(tripRq.getPassenger().getFirst_name()+" "+tripRq.getPassenger().getLast_name());
        trip.setDriver(tripRq.getDriver().getFirst_name()+" "+ tripRq.getDriver().getLast_name());
        trip.setCar(tripRq.getCar().getPlate());
        trip.setStatus(tripRq.getStatus());
        trip.setCheckCode(tripRq.getCheck_code());
        trip.setPrice(tripRq.getPrice());

        //BeanUtils.copyProperties(studentRq,student);
        return  tripRepository.save(trip).map(
                trip1 -> {
                    tripRs.setId(trip1.getId());
                    tripRs.setStart(tripRq.getStart());
                    tripRs.setEnd(tripRq.getEnd());
                    tripRs.setCountry(tripRq.getCountry().getName());
                    tripRs.setCity(tripRq.getCity().getName());
                    tripRs.setPassenger(trip1.getPassenger());
                    tripRs.setDriver(trip1.getDriver());
                    tripRs.setCar(trip1.getCar());
                    tripRs.setStatus(trip1.getStatus());
                    tripRs.setCheck_code(tripRq.getCheck_code());
                    tripRs.setPrice(tripRq.getPrice());
                    return tripRs;
                }
        );


    }

    @Override
    public Flux<TripRs> saveTripAll(List<TripRq> listTripRq) throws ExecutionException, InterruptedException {


        List<Trip> tripList = new ArrayList<>();

        for(TripRq tripRq : listTripRq) {
            Trip trip = new Trip();
            trip.setStartAddress(tripRq.getStart().getPickup_address());
            trip.setStartDate(tripRq.getStart().getDate().$date);
            trip.setStartType(tripRq.getStart().getPickup_location().getType());
            trip.setStartCoordinates(tripRq.getStart().getPickup_location().getCoordinates()[0] +
                    "," + tripRq.getStart().getPickup_location().getCoordinates()[1]);

            trip.setEndAddress(tripRq.getEnd().getPickup_address());
            trip.setEndDate(tripRq.getEnd().getDate()!=null ? tripRq.getEnd().getDate().$date:null);
            trip.setEndType(tripRq.getEnd().getPickup_location().getType());
            trip.setEndCoordinates(tripRq.getEnd().getPickup_location().getCoordinates()[0] +
                    "," + tripRq.getEnd().getPickup_location().getCoordinates()[1]);

            trip.setCountry(tripRq.getCountry().getName());
            trip.setCity(tripRq.getCity().getName());
            trip.setPassenger(tripRq.getPassenger().getFirst_name()+" "+tripRq.getPassenger().getLast_name());
            trip.setDriver(tripRq.getDriver().getFirst_name()+" "+tripRq.getDriver().getLast_name());
            trip.setCar(tripRq.getCar().getPlate());
            trip.setStatus(tripRq.getStatus());
            trip.setCheckCode(tripRq.getCheck_code());
            trip.setPrice(tripRq.getPrice());
            tripList.add(trip);
        }

        //BeanUtils.copyProperties(studentRq,student);
        return tripRepository.saveAll(tripList).map(
                trips -> {
                    TripRs tripRs = new TripRs();
                    tripRs.setId(trips.getId());

                    AddressRs startRs = new AddressRs();
                    Dates date = new Dates();
                    date.$date=(trips.getStartDate());
                    startRs.setDate(date);
                    startRs.setPickup_address(trips.getStartAddress());
                    LocationRs locationRs = new LocationRs();
                    locationRs.setType(trips.getStartType());
                    locationRs.setCoordinates(trips.getStartCoordinates().split(","));
                    startRs.setPickup_location(locationRs);
                    tripRs.setStart(startRs);

                    AddressRs endRs = new AddressRs();
                    date.$date = (trips.getEndDate());
                    endRs.setDate(date);
                    endRs.setPickup_address(trips.getEndAddress());
                    locationRs.setType(trips.getEndType());
                    locationRs.setCoordinates(trips.getEndCoordinates().split(","));
                    endRs.setPickup_location(locationRs);
                    tripRs.setEnd(endRs);

                    tripRs.setCountry(trips.getCountry());
                    tripRs.setCity(trips.getCity());
                    tripRs.setPassenger(trips.getPassenger());
                    tripRs.setDriver(trips.getDriver());
                    tripRs.setCar(trips.getCar());
                    tripRs.setStatus(trips.getStatus());
                    tripRs.setCheck_code(trips.getCheckCode());
                    tripRs.setPrice(trips.getPrice());
                    return tripRs;
                  }
                );

        }

    public Flux<CityCount> getTotalCityAll(){

        return this.databaseClient
                .sql("SELECT count(*) as total, city FROM trip group by city")
                .map((row, rowMetadata) -> {
                    Long total = row.get("total", Long.class);
                    String city = row.get("city", String.class);
                    CityCount cityCount = new CityCount(city,total);
                    return cityCount;
                })
                .all();
    }

    public Flux<CountryCount> getTotalCountryAll(){

        return this.databaseClient
                .sql("SELECT count(*) as total, country FROM trip group by country")
                .map((row, rowMetadata) -> {
                    Long total = row.get("total", Long.class);
                    String country = row.get("country", String.class);
                    CountryCount cityCount = new CountryCount(country,total);
                    return cityCount;
                })
                .all();
    }

    public Flux<TripCount> getTotalAll(){

        return this.databaseClient
                .sql("SELECT count(*) as total, status  FROM trip group by status")
                .map((row, rowMetadata) -> {
                    Long total = row.get("total", Long.class);
                    String country = row.get("status", String.class);
                    TripCount cityCount = new TripCount(country,total);
                    return cityCount;
                })
                .all();
    }
}