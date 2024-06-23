package Clinica.ClinicaOdontologica.controller;

import Clinica.ClinicaOdontologica.dto.PacienteDTO;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.PacienteService;
import Clinica.ClinicaOdontologica.entity.Paciente;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@AllArgsConstructor
public class PacienteController {

    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO paciente){

        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));

    }

    @GetMapping (path = "/id/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok(pacienteService.buscarPorId(id));

    }

    @GetMapping (path = "/listar")
    public ResponseEntity<List<PacienteDTO>> listarPacientes () {

        return ResponseEntity.ok(pacienteService.listarTodos());

    }

    @PutMapping (path = "/actualizar")
    public ResponseEntity<PacienteDTO> actualizarDatos(@RequestBody PacienteDTO paciente) throws ResourceNotFoundException {

        return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));

    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) throws ResourceNotFoundException {

        pacienteService.eliminarPorId(id);
        return ResponseEntity.ok("Eliminado con exito");

    }

    @GetMapping (path = "/buscarporemail/{email}")
    public ResponseEntity<PacienteDTO> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException {

        return ResponseEntity.ok(pacienteService.buscarPorEmail(email));

    }

    @GetMapping (path = "/nombre/{nombre}")
    public ResponseEntity<PacienteDTO> buscarPorNombre(@PathVariable String nombre) throws ResourceNotFoundException {

        return ResponseEntity.ok(pacienteService.buscarPorNombre(nombre));

    }

}