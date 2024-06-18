package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.entity.Turno;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public Turno nuevoTurno (Turno turno){
        return turnoRepository.save(turno);
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
