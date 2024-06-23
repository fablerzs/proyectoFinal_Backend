package Clinica.ClinicaOdontologica.controller;


import Clinica.ClinicaOdontologica.dto.OdontologoDTO;
import Clinica.ClinicaOdontologica.exception.BadRequestException;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<OdontologoDTO> guardarOdontologo(@RequestBody OdontologoDTO odontologo) throws BadRequestException {

        if(null == odontologo.getNombre() || odontologo.getNombre().isBlank() ||
            null == odontologo.getApellido() || odontologo.getApellido().isBlank() ||
            null == odontologo.getMatricula())
            throw new BadRequestException("El odontólogo tiene información incompleta");

        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping(path = "/buscarid/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));

    }

    @GetMapping(path = "/listartodos")
    public ResponseEntity<List<OdontologoDTO>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {

        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<OdontologoDTO> actualizarDatos(@RequestBody OdontologoDTO odontologo) throws ResourceNotFoundException {

        return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));


    }
}
