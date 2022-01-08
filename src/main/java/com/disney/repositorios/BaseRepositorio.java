/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.repositorios;

import com.disney.entidades.Base;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean 
public interface BaseRepositorio <D extends Base, ID extends Serializable> extends JpaRepository<D, ID>{

}

