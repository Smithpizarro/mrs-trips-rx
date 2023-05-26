package pe.business.app.strips.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Setter
@Data
@ToString
public class CityCount {

    private String city;
    private Long total;

    public  CityCount(String city, Long total){
     this.city = city;
     this.total = total;

    }
}
