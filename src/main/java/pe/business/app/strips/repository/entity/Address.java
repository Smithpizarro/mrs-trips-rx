package pe.business.app.strips.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "address")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Address {

    @Id
    private int  id;

    @NotNull(message = "date must not be null")
    @NotEmpty(message = "date must not be empty")
    private String dates;

    @NotNull(message = "addresss must not be null")
    private String addresss;

    @NotNull(message = "location not be null")
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "location_id", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private int locationId;



}
