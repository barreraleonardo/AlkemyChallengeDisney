/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.repositorios;

import com.disney.entidades.Pelicula;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaRepositorio extends BaseRepositorio <Pelicula, Long> {
    
//    
//     @Query ("SELECT c.titulo, c.imagen, c.fechadecreacion FROM Pelicula c")
//       public List <Pelicula> listarTodas ();
//       
//     @Query ( value = "SELECT * FROM Pelicula WHERE titulo= :titulo", nativeQuery = true)            
//    public List <Pelicula> buscarPorPelicula (@Param("titulo") String titulo);
//    
//        
////    @Query ("SELECT c FROM Pelicula c ORDER BY c.fechadecreacion")
////     public List <Pelicula> listarCreacionASC ();
////    
////   @Query ("SELECT c FROM Pelicula c ORDER BY c.fechadecreacion DESC")
////    public List <Pelicula> listarCreacionDESC ();
//    
//    @Query ("SELECT c FROM Pelicula c WHERE genero.id = :id")
//    public List <Pelicula> vincularGeneros(@Param("id") String id);
//    
//    @Query ("SELECT c FROM Pelicula c WHERE c.titulo = :titulo")
//    public Pelicula buscarPorNombre (@Param ("titulo") String titulo); 
//    
    
}

