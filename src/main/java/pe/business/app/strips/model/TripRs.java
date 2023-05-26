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
public class TripRs {

 public int  id;
 public AddressRs start;
 public AddressRs end;
 public String country;
 public String city;
 public String passenger;
 public String driver;
 public String car;
 public String status;
 public int check_code;
 public double price;

}
