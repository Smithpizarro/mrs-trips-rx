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
public class AddressRs {


 public Dates date;
 public String pickup_address;
 public LocationRs pickup_location;

}
