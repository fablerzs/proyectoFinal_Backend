package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.entity.Turno;
import Clinica.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
