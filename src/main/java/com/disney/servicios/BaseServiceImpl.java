
package com.disney.servicios;

import com.disney.Excepciones.ExcepcionesServicio;
import com.disney.entidades.Base;
import com.disney.repositorios.BaseRepositorio;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;


    public abstract class BaseServiceImpl<D extends Base, ID extends Serializable> implements BaseService<D,ID> {
    protected BaseRepositorio<D,ID> baseRepositorio;
    
    public BaseServiceImpl (BaseRepositorio<D,ID> baseRepositorio){
        this.baseRepositorio = baseRepositorio;
    }
    
    
    @Override
    @Transactional
    public List<D> findAll() throws ExcepcionesServicio {
        try {
            List<D> entities = baseRepositorio.findAll();
            return entities;
        } catch (Exception e) {
            throw new ExcepcionesServicio(e.getMessage());
        }

    }

    @Override
    @Transactional
    public D findById(ID id) throws ExcepcionesServicio {
        try {
            Optional<D> entitiOpcional = baseRepositorio.findById(id);
            return entitiOpcional.get();
        } catch (Exception e) {
            throw new ExcepcionesServicio(e.getMessage());
        }
    }


    @Override
    @Transactional
    public D save(D entity) throws ExcepcionesServicio {
        try {
            entity = baseRepositorio.save(entity);
            return entity;
        } catch (Exception e) {
            throw new ExcepcionesServicio(e.getMessage());
        }
    }
  


    @Override
    @Transactional
    public D update(ID id, D entity) throws ExcepcionesServicio {
        Optional<D> entityOptional = baseRepositorio.findById(id);
        D entityUpdate = entityOptional.get();
        entityUpdate = baseRepositorio.save(entity);
        return entityUpdate;
    }

        @Override
        @Transactional
        public boolean delete(ID id) throws ExcepcionesServicio {
        try {
			if(baseRepositorio.existsById(id)) {
				baseRepositorio.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new ExcepcionesServicio(e.getMessage());
		}

       
    
    
}
}

