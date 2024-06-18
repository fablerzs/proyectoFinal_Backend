package Clinica.ClinicaOdontologica.security;

import Clinica.ClinicaOdontologica.entity.Usuario;
import Clinica.ClinicaOdontologica.entity.UsuarioRole;
import Clinica.ClinicaOdontologica.repository.UsuarioRepository;
import Clinica.ClinicaOdontologica.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatosIniciales implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String passSinCifrar= "admin";
        String passCifrado= bCryptPasswordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("admin","admin","admin@admin.com",passCifrado,UsuarioRole.ROLE_ADMIN);
        System.out.println("pass cifrado: "+passCifrado);
        Usuario usuario1 = new Usuario("mau","user1","mau@mau.com",passCifrado, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario);

    }
}
