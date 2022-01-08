package com.disney.controladores;

import com.disney.entidades.Pelicula;
import com.disney.servicios.PeliculaServicio;
import com.disney.servicios.PeliculaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



    
@PreAuthorize("authenticated")
@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/v1/peliculas")
public class PeliculaController {
    
    @Autowired
    private PeliculaServicioImpl peliculaServicio;
    
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
    
 
    
    
    @GetMapping("/{id}")
     public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
    
     @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
     public ResponseEntity<?> save(@RequestBody Pelicula entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
     
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pelicula entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
     
    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(peliculaServicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }  
     
     
     
    
}

