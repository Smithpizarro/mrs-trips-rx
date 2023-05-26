package pe.business.app.strips.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripRq {

 public int id;
 public AddressRs start;
 public AddressRs end;
 public Country country;
 public City city;
 public Passenger passenger;
 public Driver driver;
 public Car car;
 public String status;
 public int check_code;
 public  Dates createdAt;
 public  Dates updatedAt;
 public double price;
 public LocationRs driver_location;

}
