package Clinica.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter @Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String DNI;
    @Column
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;
    @Column
    private String email;

}
