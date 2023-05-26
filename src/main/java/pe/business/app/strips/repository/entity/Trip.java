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
import javax.validation.constraints.Positive;

@Table(name = "trip")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Trip {

    @Id
    private int  id;

    @NotNull(message = "startdate not be null")
    @Column(name = "start_date", nullable=false)
    private String startDate;

    @NotNull(message = "start_address must not be null")
    @Column(name = "start_address", nullable=false)
    private String startAddress;

    @NotNull(message = "start_type must not be null")
    @NotEmpty(message = "start_type must not be empty")
    @Column(name = "start_type", nullable=false)
    private String startType;

    @NotNull(message = "start_coordinates not be null")
    @Column(name = "start_coordinates", nullable=false)
    private String startCoordinates;


    @Column(name = "end_date")
    private String endDate;

    @NotNull(message = "end_address must not be null")
    @Column(name = "end_address", nullable=false)
    private String endAddress;

    @NotNull(message = "end_type must not be null")
    @NotEmpty(message = "end_type must not be empty")
    @Column(name = "end_type", nullable=false)
    private String endType;

    @NotNull(message = "end_coordinates not be null")
    @Column(name = "end_coordinates", nullable=false)
    private String endCoordinates;

    @NotNull(message = "status must not be null")
    private String country;

    @NotNull(message = "status must not be null")
    private String city;

    @NotNull(message = "passenger not be null")
    @Column(name = "passenger", nullable=false)
    private String passenger;

    @NotNull(message = "driver not be null")
    @Column(name = "driver", nullable=false)
    private String driver;

    @NotNull(message = "car not be null")
    @Column(name = "car", nullable=false)
    private String car;

    @NotNull(message = "status must not be null")
    private String status;

    @Positive(message = "check_code must be mayor than zero")
    @NotNull(message = "check_code")
    private int checkCode;

    @Positive(message = "price must be mayor than zero")
    private Double price;

}
