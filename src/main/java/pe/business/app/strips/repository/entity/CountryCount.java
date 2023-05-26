package pe.business.app.strips.repository.entity;

import lombok.*;


@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CountryCount {

    private String country;
    private Long total;

}
