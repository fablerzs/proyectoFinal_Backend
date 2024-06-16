package Clinica.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "turnos")
@Getter @Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    private Odontologo odontologo;
    @Column
    private LocalDate fecha;

}
