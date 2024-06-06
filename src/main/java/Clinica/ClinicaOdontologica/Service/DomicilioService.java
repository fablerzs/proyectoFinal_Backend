package Clinica.ClinicaOdontologica.Service;

import Clinica.ClinicaOdontologica.DAO.DomicilioDAOH2;
import Clinica.ClinicaOdontologica.DAO.iDao;
import Clinica.ClinicaOdontologica.entity.Domicilio;

public class DomicilioService {
    private iDao<Domicilio> domicilioiDao;

    public DomicilioService () {
        domicilioiDao = new DomicilioDAOH2();
    }

    public Domicilio guardarDomicilio (Domicilio domicilio){
        return domicilioiDao.guardar(domicilio);
    }

    public Domicilio buscarDomicilioID (int id){
        return domicilioiDao.buscarID(id);
    }
}
