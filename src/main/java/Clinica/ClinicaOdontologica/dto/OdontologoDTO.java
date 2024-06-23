package Clinica.ClinicaOdontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoDTO {
        private Long id;
        private Integer matricula;
        private String nombre;
        private String apellido;

        public OdontologoDTO(Integer matricula, String nombre, String apellido) {
                this.matricula = matricula;
                this.nombre = nombre;
                this.apellido = apellido;
        }
}
