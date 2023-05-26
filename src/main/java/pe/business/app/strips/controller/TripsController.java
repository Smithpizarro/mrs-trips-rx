package pe.business.app.strips.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.business.app.strips.controller.exception.ServiceException;
import pe.business.app.strips.model.TransactionRs;
import pe.business.app.strips.model.TripRq;
import pe.business.app.strips.model.TripRs;
import pe.business.app.strips.repository.entity.CityCount;
import pe.business.app.strips.repository.entity.CountryCount;
import pe.business.app.strips.repository.entity.TripCount;
import pe.business.app.strips.service.TripsService;
import pe.business.app.strips.util.Constant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/trips")
@Validated
public class TripsController {

    @Autowired
    TripsService tripsService;


    public static final String CODE_POTENCIAL="7003";


    @PostMapping(value = "/uploads" )
    public Flux<TripRs> uploadFiles() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<TripRq>> typeReference = new TypeReference<List<TripRq>>(){};
        Flux<TripRs> tripsRs = Flux.just();
        try {
            ClassPathResource staticDataResource = new ClassPathResource("tripss.json");

            List<TripRq> trips = mapper.readValue(staticDataResource.getInputStream(),typeReference);
            tripsRs = tripsService.saveTripAll(trips);

        } catch (IOException e){
            System.out.println("Unable to save trips: " + e.getMessage());
        }
        return tripsRs;

    }

    @GetMapping
    public Flux<TripRs> listTrips(@RequestParam(name = "status" , required = false) String status){
        Flux<TripRs> students = Flux.just();
        if ( status==null) {
            students = tripsService.getTrips(Constant.FIND_ALL,null);
        } else {
            students = tripsService.getTrips(Constant.FIND_BY_STATUS,status);
        }

        return  students;
    }

    @GetMapping(value = "/citytotal" )
    public Flux<CityCount> listTotalCity(){
       return   tripsService.getTotalCityAll();
    }

    @GetMapping(value = "/countrytotal" )
    public Flux<CountryCount> listTotalCountry(){
        return   tripsService.getTotalCountryAll();
    }

    @GetMapping(value = "/tripstotal" )
    public Flux<TripCount> listTotalTrips(){
        return   tripsService.getTotalAll();
    }

    @PostMapping
    public Mono<ResponseEntity<TransactionRs<TripRs>>> createTrip(
            @Valid @RequestBody TripRq tripRq) throws ExecutionException, InterruptedException {
        TransactionRs<TripRs> response = new TransactionRs<TripRs>();

       return tripsService.saveTrip(tripRq).map(
                studentRs1 -> {
                    response.setRespuesta(studentRs1);
                    response.isSuccess();
                    return ResponseEntity.status( HttpStatus.OK).body(response);
                }
        );

    }

    @PutMapping
    public Mono<ResponseEntity<TransactionRs<TripRs>>> updatedTrip(
            @Valid @RequestBody TripRq tripRq) {
        TransactionRs<TripRs> response = new TransactionRs<TripRs>();

        return tripsService.updatedTrip(tripRq).map(
                studentRs1 -> {
                    response.setRespuesta(studentRs1);
                    response.isSuccess();
                    return ResponseEntity.status( HttpStatus.OK).body(response);
                }
        );

    }



}
