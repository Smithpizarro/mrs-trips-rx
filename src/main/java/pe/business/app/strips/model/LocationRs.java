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
public class LocationRs {

 public String type;
 public String[] coordinates;

}
