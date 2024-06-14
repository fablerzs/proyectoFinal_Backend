package Clinica.ClinicaOdontologica.controller;

import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.PacienteService;
import Clinica.ClinicaOdontologica.entity.Paciente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping (path = "/id/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorId(id);
        if (pacientebuscado.isPresent()){
            return ResponseEntity.ok(pacientebuscado.get());
        }else{
            throw new ResourceNotFoundException("Paciente con id: "+id+" no existe en la base de datos");
        }
    }

    @GetMapping (path = "/listar")
    public ResponseEntity<List<Paciente>> listarPacientes (){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @PutMapping (path = "/actualizar")
    public String actualizarDatos(@RequestBody Paciente paciente){
        pacienteService.actualizarPaciente(paciente);
        return paciente.toString() + "***** Paciente actualizado****";
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorId(id);
        if (pacientebuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Eliminado con exito");
        }else{
            throw new ResourceNotFoundException("El paciente con el id: "+id+" no existe en la base de datos");
        }
    }

    @GetMapping (path = "/buscarporemail/{email}")
    public ResponseEntity<Paciente> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException {
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorEmail(email);
        if (pacientebuscado.isPresent()){
            return ResponseEntity.ok(pacientebuscado.get());
        }else{
            throw new ResourceNotFoundException("El paciente con el email: "+email+" no existe en la base de datos");
        }
    }

}