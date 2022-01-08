
package com.disney.entidades;


import com.disney.entidades.Base;
import com.disney.enums.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name= "Usuario")
public class Usuario extends Base {
   

  
  private  String nombre;
  private  String apellido;
  private  String mail;
  private  String clave;
  @Enumerated(EnumType.STRING)
  private Rol rol;
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + getNombre() + ", apellido=" + getApellido() + ", mail=" + getMail() + ", clave=" + getClave() + '}';
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
  
    
}