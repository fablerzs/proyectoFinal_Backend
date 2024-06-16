package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.entity.Paciente;
import Clinica.ClinicaOdontologica.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public Paciente guardarPaciente (Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorEmail(String email){
        return pacienteRepository.findByEmail(email);
    }

    public Optional<Paciente> buscarPorNombre(String nombre){
        return pacienteRepository.findByNombre(nombre);
    }

    public Optional<Paciente> buscarPorId (Long id){
        return pacienteRepository.findById(id);
    }

    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
