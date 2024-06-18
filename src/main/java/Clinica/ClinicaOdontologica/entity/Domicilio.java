package Clinica.ClinicaOdontologica.entity;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "domicilios")
@Getter @Setter
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String calle;
    @Column
    private  Integer numero;
    @Column
    private String localidad;
    @Column
    private String provincia;
}
