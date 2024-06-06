package Clinica.ClinicaOdontologica;

import Clinica.ClinicaOdontologica.DAO.BaseDatos;
import Clinica.ClinicaOdontologica.entity.Domicilio;
import Clinica.ClinicaOdontologica.entity.Paciente;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        BaseDatos.crearTablas();
        Domicilio domicilio1 = new Domicilio("n11",132,"metroplex","apodaca");
        Paciente paciente1 = new Paciente("ale","perez","123AB", LocalDate.now(),domicilio1,"mauri@gmail.com");
        Paciente paciente2 = new Paciente("aleja","perez","123AA34B", LocalDate.now(),domicilio1,"ALEX@gmail.com");
        Paciente paciente3 = new Paciente(1,"alejaNDRINA","perez","123AA34B", LocalDate.now(),domicilio1,"ALEX@gmail.com");
        PacienteService serv = new PacienteService();
        serv.guardarPaciente(paciente1);
        serv.guardarPaciente(paciente2);


        System.out.println(serv.listarPacientes());
        serv.actualizarPaciente(paciente3);
        System.out.println(serv.listarPacientes());
    }
}
