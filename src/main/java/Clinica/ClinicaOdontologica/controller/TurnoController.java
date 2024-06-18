package Clinica.ClinicaOdontologica.controller;

import Clinica.ClinicaOdontologica.entity.Odontologo;
import Clinica.ClinicaOdontologica.entity.Paciente;
import Clinica.ClinicaOdontologica.entity.Turno;
import Clinica.ClinicaOdontologica.exception.BadRequestException;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.OdontologoService;
import Clinica.ClinicaOdontologica.service.PacienteService;
import Clinica.ClinicaOdontologica.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/turno")
public class TurnoController {

    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());
        if(pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            turno.setPaciente(pacienteBuscado.get());
            turno.setOdontologo(odontologoBuscado.get());
            return ResponseEntity.ok(turnoService.nuevoTurno(turno));

        } else
            throw new BadRequestException("No existe el odontologo o el paciente indicados");
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Turno> turnoBuscado = turnoService.buscarPorId(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else {
            throw new ResourceNotFoundException("Turno con id: "+id+" no existe");
        }
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) throws ResourceNotFoundException{
        Optional<Turno> turnoBuscado = turnoService.buscarPorId(turno.getId());
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoService.actualizarTurno(turno));
        }
        else {
            throw new ResourceNotFoundException("Turno con id: "+turno.getId()+" no existe");
        }
    }


}
