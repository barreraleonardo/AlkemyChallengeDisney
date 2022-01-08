
package com.disney.servicios;

import com.disney.entidades.Pelicula;
import com.disney.repositorios.BaseRepositorio;
import com.disney.repositorios.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServicioImpl extends BaseServiceImpl<Pelicula,Long> implements PeliculaServicio {
    
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    
    public PeliculaServicioImpl(BaseRepositorio<Pelicula, Long> baseRepositorio) {
        super(baseRepositorio);
    }
    
}
