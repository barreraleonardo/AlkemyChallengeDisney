
package com.disney.servicios;

import com.disney.entidades.Personaje;
import com.disney.repositorios.BaseRepositorio;
import com.disney.repositorios.PersonajeRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServicioImpl extends BaseServiceImpl<Personaje,Long> implements PersonajeServicio {
    
    
  @Autowired  
   private PersonajeRepositorio personajeRepositorio;

    public PersonajeServicioImpl(BaseRepositorio<Personaje, Long> baseRepositorio) {
        super(baseRepositorio);
    }
  
   
   

    
}

