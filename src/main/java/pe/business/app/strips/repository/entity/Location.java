package pe.business.app.strips.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "location")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Location {

    @Id
    private int  id;

    @NotNull(message = "type must not be null")
    @NotEmpty(message = "type must not be empty")
    private String type;

    @NotNull(message = "coordinatex not be null")
    @Column("coordinatex")
    private String coordinatex;


    @NotNull(message = "coordinatey not be null")
    @Column("coordinatey")
    private String coordinatey;


}
