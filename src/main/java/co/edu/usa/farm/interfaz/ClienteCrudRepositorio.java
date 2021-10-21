package co.edu.usa.farm.interfaz;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.farm.entidad.Cliente;

public interface ClienteCrudRepositorio extends CrudRepository<Cliente,Long>{
    
}
