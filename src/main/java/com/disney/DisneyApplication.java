package com.disney;

import com.disney.servicios.UsuarioServicio;
import com.disney.servicios.UsuarioServicioImpl;
import static javafx.scene.input.KeyCode.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("com.disney.repositorios")
public class DisneyApplication {
        
         @Autowired
        UsuarioServicioImpl usuarioServicio;
   
	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}
        
      @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usuarioServicio)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

}
