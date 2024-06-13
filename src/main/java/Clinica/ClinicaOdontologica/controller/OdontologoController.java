package Clinica.ClinicaOdontologica.controller;


import Clinica.ClinicaOdontologica.exception.BadRequestException;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.OdontologoService;
import Clinica.ClinicaOdontologica.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {

        if(null == odontologo.getNombre() || odontologo.getNombre().isBlank() ||
            null == odontologo.getApellido() || odontologo.getApellido().isBlank() ||
            null == odontologo.getMatricula())
            throw new BadRequestException("El odontólogo tiene información incompleta");

        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping(path = "/buscarid/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoService.buscarOdontologoPorId(id);
        if (odontologo.isPresent())
            return ResponseEntity.ok(odontologo.get());
        else
            throw new ResourceNotFoundException("No existe el id: " + id);
    }

    @GetMapping(path = "/listartodos")
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @DeleteMapping(path = "/eliminar")
    public ResponseEntity<String> eliminarOdontologo(@RequestParam("id") Long id) throws ResourceNotFoundException {

        Optional<Odontologo> odontologo = odontologoService.buscarOdontologoPorId(id);
        if(odontologo.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Odontologo con id "+ id +" ha sido eliminado con exito");}
        else
            throw new ResourceNotFoundException("No existe el id: " + id);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Odontologo> actualizarDatos(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> optionalOdontologo = odontologoService.buscarOdontologoPorId(odontologo.getId());

        if(optionalOdontologo.isPresent()) {
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok(odontologo);
        }
        else {
            throw new ResourceNotFoundException("No existe el odontologo con id: " + odontologo.getId());
        }

    }
}
