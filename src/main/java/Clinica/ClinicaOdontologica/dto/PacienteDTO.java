package Clinica.ClinicaOdontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;
    private LocalDate fechaIngreso;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
    private String email;

    public PacienteDTO(String nombre, String apellido, String DNI, LocalDate fechaIngreso, String calle, Integer numero, String localidad, String provincia, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.email = email;
    }
}
