package Clinica.ClinicaOdontologica.controller;


import Clinica.ClinicaOdontologica.service.PacienteService;
import Clinica.ClinicaOdontologica.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping (path = "/agregar")
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente){

        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping (path = "/buscarid/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id){
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorId(id);
        if (pacientebuscado.isPresent()){
            return ResponseEntity.ok(pacientebuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping (path = "/mostrar")
    public ResponseEntity<List<Paciente>> listarPacientes (){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @PutMapping (path = "/actualizar")
    public String actualizarDatos(@RequestBody Paciente paciente){
        pacienteService.actualizarPaciente(paciente);
        return paciente.toString() + "***** Paciente actualizado****";
    }

    @DeleteMapping (path = "/eliminar/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id){
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorId(id);
        if (pacientebuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Eliminado con exito");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping (path = "/buscarporemail/{email}")
    public ResponseEntity<Paciente> buscarPorEmail(@PathVariable String email){
        Optional<Paciente> pacientebuscado = pacienteService.buscarPorEmail(email);
        if (pacientebuscado.isPresent()){
            return ResponseEntity.ok(pacientebuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }












}