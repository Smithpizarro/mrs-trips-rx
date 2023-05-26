package pe.business.app.strips.repository.entity;

import lombok.*;


@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TripCount {

    private String status;
    private Long total;


}
