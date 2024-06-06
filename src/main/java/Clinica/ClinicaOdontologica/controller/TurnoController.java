package Clinica.ClinicaOdontologica.controller;

import Clinica.ClinicaOdontologica.entity.Turno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;


    public TurnoController() {
        turnoService = new TurnoService();
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        PacienteService pacienteService = new PacienteService();
        OdontologoService odontologoService = new OdontologoService();
        if (pacienteService.buscarPaciente(turno.getPaciente().getId())!=null && odontologoService.buscarPorId(turno.getOdontologo().getId())!=null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else {
            return ResponseEntity.badRequest().body(turno);
        }
    }


}*/
