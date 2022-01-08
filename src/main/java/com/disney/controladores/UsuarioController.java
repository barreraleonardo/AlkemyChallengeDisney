
package com.disney.controladores;

import com.disney.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.disney.servicios.UsuarioServicioImpl;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/v1/usuarios")
public class UsuarioController {
    
    
    @Autowired
    private UsuarioServicioImpl usuarioServicio;
    
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
    
    
    @GetMapping("/{id}")
     public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
    
   @PostMapping("")
     public ResponseEntity<?> save(@RequestBody Usuario entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
     
     
   
     
     
     
     @PutMapping("/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }
     
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioServicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intenta mas tarde\"}");
        }
    }  
    
    
    
}

     
     
    
