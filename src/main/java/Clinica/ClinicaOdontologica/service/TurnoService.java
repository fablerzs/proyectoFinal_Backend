package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.entity.Odontologo;
import Clinica.ClinicaOdontologica.entity.Paciente;
import Clinica.ClinicaOdontologica.entity.Turno;
import Clinica.ClinicaOdontologica.exception.BadRequestException;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.repository.OdontologoRepository;
import Clinica.ClinicaOdontologica.repository.PacienteRepository;
import Clinica.ClinicaOdontologica.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {

    private TurnoRepository turnoRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    public Turno nuevoTurno (Turno turno) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(turno.getOdontologo().getId());

        if(pacienteBuscado.isPresent() && odontologoBuscado.isPresent()) {
            turno.setPaciente(pacienteBuscado.get());
            turno.setOdontologo(odontologoBuscado.get());
            return turnoRepository.save(turno);
        }
        throw new BadRequestException("No existe el odontologo o el paciente indicados");
    }

    public List<Turno> listarTurnos(){
        return turnoRepository.findAll();
    }

    public void eliminarTurno(Long id) throws ResourceNotFoundException{
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if(optionalTurno.isPresent())
            turnoRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("El turno no existe");
    }

    public Optional<Turno> buscarPorId(Long id){
        return turnoRepository.findById(id);
    }

    public Turno actualizarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
}
