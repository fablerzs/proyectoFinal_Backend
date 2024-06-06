package Clinica.ClinicaOdontologica.controller;


import Clinica.ClinicaOdontologica.entity.Odontologo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    public OdontologoController() {
        this.odontologoService = new OdontologoService();
    }
    @PostMapping(path = "/guardar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.agregarOdontologo(odontologo);
    }

    @GetMapping(path = "/buscarid")
    public Odontologo buscarPorId(@RequestParam("matricula") Integer id){
        return odontologoService.buscarPorId(id);
    }
    @GetMapping(path = "/listartodos")
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.mostrarOdontologos());
    }

    @DeleteMapping(path = "/eliminar")
    public String eliminarOdontologo(@RequestParam("id") Integer id){
        odontologoService.eliminar(id);
        return "Odontologo con id "+id +" ha sido eliminado con exito";
    }

    @PutMapping(path = "/actualizar")
    public String actualizarDatos(@RequestBody Odontologo odontologo){
        odontologoService.actualizar(odontologo);
        return "odontologo con matricula : " + odontologo.getMatricula() + " actualizado con exito";
    }




}
