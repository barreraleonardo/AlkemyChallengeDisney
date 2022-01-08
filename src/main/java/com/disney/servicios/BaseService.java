/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.servicios;

import com.disney.Excepciones.ExcepcionesServicio;
import com.disney.entidades.Base;
import java.io.Serializable;
import java.util.List;


public interface BaseService <D extends Base, ID extends Serializable> {
    public List<D> findAll() throws ExcepcionesServicio;
    public D findById(ID id) throws  ExcepcionesServicio;
    public D save(D entity)throws  ExcepcionesServicio;
    public D update (ID id, D entity )throws  ExcepcionesServicio;
    public boolean delete (ID id)throws  ExcepcionesServicio;
}

