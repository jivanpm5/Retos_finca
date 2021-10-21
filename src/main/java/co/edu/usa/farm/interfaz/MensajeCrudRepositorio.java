package co.edu.usa.farm.interfaz;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.farm.entidad.Mensaje;

public interface MensajeCrudRepositorio extends CrudRepository<Mensaje,Long> {
    
}
