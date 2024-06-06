package Clinica.ClinicaOdontologica;

import Clinica.ClinicaOdontologica.DAO.BaseDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		BaseDatos.crearTablas();
			SpringApplication.run(ClinicaOdontologicaApplication.class, args);

	}


}
