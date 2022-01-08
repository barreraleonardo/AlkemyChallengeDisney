
package com.disney.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "Pelicula")
public class Pelicula  extends Base  {
    
private  String  imagen;
private  String titulo;
@Temporal(javax.persistence.TemporalType.DATE)
private Date fechadecreación;
private Integer calificacion; //(del 1 al 5).
@OneToMany (mappedBy = "pelicula")
private List <Personaje> personajes;
@ManyToOne
private Genero genero;
    
   


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechadecreación() {
        return fechadecreación;
    }

    public void setFechadecreación(Date fechadecreación) {
        this.fechadecreación = fechadecreación;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

   

    
   



}
