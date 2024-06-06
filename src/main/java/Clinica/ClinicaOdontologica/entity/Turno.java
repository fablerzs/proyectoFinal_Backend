package Clinica.ClinicaOdontologica.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;


}
