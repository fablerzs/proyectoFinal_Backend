package Clinica.ClinicaOdontologica.controller;

import Clinica.ClinicaOdontologica.entity.Turno;
import Clinica.ClinicaOdontologica.exception.BadRequestException;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/turno")
public class TurnoController {

    private TurnoService turnoService;


    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno) throws BadRequestException {

        return ResponseEntity.ok(turnoService.nuevoTurno(turno));

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
        if(turnoBuscado.isPresent())
            return ResponseEntity.ok(turnoBuscado.get());

        throw new ResourceNotFoundException("Turno con id: "+id+" no existe");

    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) throws ResourceNotFoundException{
        Optional<Turno> turnoBuscado = turnoService.buscarPorId(turno.getId());
        if(turnoBuscado.isPresent())
            return ResponseEntity.ok(turnoService.actualizarTurno(turno));

        throw new ResourceNotFoundException("Turno con id: "+turno.getId()+" no existe");
    }

}