package Clinica.ClinicaOdontologica.service;

import Clinica.ClinicaOdontologica.dto.OdontologoDTO;
import Clinica.ClinicaOdontologica.dto.PacienteDTO;
import Clinica.ClinicaOdontologica.entity.Odontologo;
import Clinica.ClinicaOdontologica.entity.Paciente;
import Clinica.ClinicaOdontologica.exception.ResourceNotFoundException;
import Clinica.ClinicaOdontologica.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OdontologoService {

    private OdontologoRepository odontologoRepository;
    private ModelMapper modelMapper;

    public OdontologoDTO guardarOdontologo(OdontologoDTO odontologo){
        return entityToOdontologoDTO(odontologoRepository.save(odontologoDTOToEntity(odontologo)));
    }

    public OdontologoDTO actualizarOdontologo(OdontologoDTO odontologo) throws ResourceNotFoundException{
        buscarOdontologoPorId(odontologo.getId());
        return entityToOdontologoDTO(odontologoRepository.save(odontologoDTOToEntity(odontologo)));
    }

    public OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException{

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent())
            return entityToOdontologoDTO(odontologo.get());

        throw new ResourceNotFoundException("No existe el id: " + id);
    }

    public List<OdontologoDTO> listarOdontologos(){
        List<Odontologo> odontologos = odontologoRepository.findAll();
        List<OdontologoDTO> odontologoDTOS = new ArrayList<OdontologoDTO>();

        odontologoDTOS = odontologos.stream().map(odontologo -> {
            return entityToOdontologoDTO(odontologo);
        }).collect(Collectors.toList());

        return odontologoDTOS;
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException{
        buscarOdontologoPorId(id);
        odontologoRepository.deleteById(id);
    }

    public Odontologo odontologoDTOToEntity(OdontologoDTO pacienteDTO){

        return modelMapper.map(pacienteDTO, Odontologo.class);
    }

    public OdontologoDTO entityToOdontologoDTO(Odontologo odontologo){

        return modelMapper.map(odontologo, OdontologoDTO.class);
    }
}
