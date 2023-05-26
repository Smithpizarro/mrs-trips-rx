package pe.business.app.strips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;


@EnableWebFlux
@EnableR2dbcAuditing
@SpringBootApplication
public class MrsTripsRxApplication {


	public static void main(String[] args) {
		SpringApplication.run(MrsTripsRxApplication.class, args);
	}


}
