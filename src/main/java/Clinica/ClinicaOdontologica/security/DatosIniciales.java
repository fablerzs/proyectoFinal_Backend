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
        String passSinCifrar2= "user";
        String passCifrado= bCryptPasswordEncoder.encode(passSinCifrar);
        String passCifrado2 = bCryptPasswordEncoder.encode(passSinCifrar2);
        Usuario usuario= new Usuario("admin","admin","admin@admin.com",passCifrado,UsuarioRole.ROLE_ADMIN);
        System.out.println("pass cifrado: "+passCifrado);
        Usuario usuario1 = new Usuario("user","user","user@user.com",passCifrado2, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario);

    }
}
