package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.dto.PacienteDTO;
import Clinica.ClinicaOdontologica.entity.Domicilio;
import Clinica.ClinicaOdontologica.entity.Paciente;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;
    private ModelMapper modelMapper;

    public PacienteDTO guardarPaciente (PacienteDTO paciente) {
        return entityToPacienteDTO(pacienteRepository.save(pacienteDTOToEntity(paciente)));
    }

    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException{
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteDTO.getId());
        if(paciente.isPresent()) {
            return entityToPacienteDTO(pacienteRepository.save(pacienteDTOToEntity(pacienteDTO)));
        }

        throw new ResourceNotFoundException("El paciente con el id: "+paciente.get()+" no existe en la base de datos");

    }

    public PacienteDTO buscarPorEmail(String email) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findByEmail(email);
        if(paciente.isPresent())
            return entityToPacienteDTO(paciente.get());
        else
            throw new ResourceNotFoundException("El paciente con el email: "+email+" no existe en la base de datos");
    }

    public PacienteDTO buscarPorNombre(String nombre) throws ResourceNotFoundException {

        Optional<Paciente> paciente = pacienteRepository.findByNombre(nombre);
        if(paciente.isPresent())
            return entityToPacienteDTO(paciente.get());
        else
            throw new ResourceNotFoundException("El paciente con el nombre: "+nombre+" no existe en la base de datos");
    }

    public PacienteDTO buscarPorId (Long id) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent())
            return entityToPacienteDTO(paciente.get());
        else
            throw new ResourceNotFoundException("El paciente con el id: "+id+" no existe en la base de datos");
    }

    public Boolean eliminarPorId(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacientebuscado = pacienteRepository.findById(id);
        if (pacientebuscado.isPresent())
            eliminarPaciente(id);

        throw new ResourceNotFoundException("El paciente con el id: "+id+" no existe en la base de datos");

    }

    public List<PacienteDTO> listarTodos(){
        List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>();
        List<Paciente> pacientes = pacienteRepository.findAll();

        pacientesDTO = pacientes.stream().map(paciente -> {
                                return entityToPacienteDTO(paciente);
                        }).collect(Collectors.toList());

        return pacientesDTO;
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public Paciente pacienteDTOToEntity(PacienteDTO pacienteDTO){
        return new Paciente(
                pacienteDTO.getId(),
                pacienteDTO.getNombre(),
                pacienteDTO.getApellido(),
                pacienteDTO.getDNI(),
                pacienteDTO.getFechaIngreso(),
                new Domicilio(
                    pacienteDTO.getCalle(),
                    pacienteDTO.getNumero(),
                    pacienteDTO.getLocalidad(),
                    pacienteDTO.getProvincia()
                ),
                pacienteDTO.getEmail());
    }

    public PacienteDTO entityToPacienteDTO(Paciente paciente){
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getDNI(),
                paciente.getFechaIngreso(),
                paciente.getDomicilio().getCalle(),
                paciente.getDomicilio().getNumero(),
                paciente.getDomicilio().getLocalidad(),
                paciente.getDomicilio().getProvincia(),
                paciente.getEmail());
    }
}
