package Clinica.ClinicaOdontologica.dto;

import java.time.LocalDate;

public record Turno(Long id, Long idPaciente, Long odOdontologo, LocalDate fecha) {
}
