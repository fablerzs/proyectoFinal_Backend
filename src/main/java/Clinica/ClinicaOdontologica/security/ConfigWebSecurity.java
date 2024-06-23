package Clinica.ClinicaOdontologica.security;

import Clinica.ClinicaOdontologica.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ConfigWebSecurity {

    private UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/odontologos/**").hasRole("ADMIN")
                                .requestMatchers("/templates/odontologo/odontologoAlta.html").hasRole("ADMIN")
                                .requestMatchers("/templates/odontologo/odontologoBusqueda.html").hasRole("ADMIN")
                                .requestMatchers("/templates/odontologo/odontologoList.html").hasRole("ADMIN")

                                .requestMatchers("/paciente/**").hasRole("ADMIN")
                                .requestMatchers("/templates/paciente/pacienteAlta.html").hasRole("ADMIN")
                                .requestMatchers("/templates/paciente/pacienteBusqueda.html").hasRole("ADMIN")
                                .requestMatchers("/templates/paciente/pacienteList.html").hasRole("ADMIN")

                                .requestMatchers("/turno/**").hasAnyRole("ADMIN", "USER")

                                .requestMatchers("/templates/turno/turnoAlta.html").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/templates/turno/turnoBusqueda.html").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/templates/turno/turnoList.html").hasAnyRole("ADMIN", "USER")

                                /* Página de h2 */
                                .requestMatchers("/login.jsp").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults())
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/templates/errores/error-403.html")
                );
        return http.build();
    }


}
