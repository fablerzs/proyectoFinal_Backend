package Clinica.ClinicaOdontologica.Service;

import Clinica.ClinicaOdontologica.entity.Odontologo;
import Clinica.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarOdontologoPorId(Long id){
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoRepository.findAll();
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

}
