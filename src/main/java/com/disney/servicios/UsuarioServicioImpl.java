
package com.disney.servicios;


import com.disney.entidades.Usuario;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.disney.repositorios.UsuarioRepositorio;
import com.disney.repositorios.BaseRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicioImpl extends BaseServiceImpl <Usuario, Long> implements UsuarioServicio, UserDetailsService{
    
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    
    public UsuarioServicioImpl (BaseRepositorio<Usuario, Long> baseRepositorio){
        
        super(baseRepositorio);
    }
    
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorMail(mail);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
                        
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol());
            permisos.add(p1);
         
            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getMail(), usuario.getClave(), permisos);
            return user;

        } else {
            return null;
        }

    }
    
        
  
}










   
