
package com.disney.servicios;

import com.disney.entidades.Genero;
import com.disney.repositorios.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServicio {
    
    
    @Autowired
    private GeneroRepositorio generorepositorio;
    
    public Genero ingresarGenero (String nombre){
        Genero genero= new Genero();
        genero.setNombre(nombre);
        
        return generorepositorio.save(genero);
    }
    
    
//    public Editorial crearEditorial(String nombre) {
//        Editorial editorial = new Editorial();
//        editorial.setNombre(nombre);
//        editorial.setAlta(true);
//
//        return editorialRepositorio.save(editorial);
    
    
    
}
