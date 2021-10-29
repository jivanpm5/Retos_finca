package co.edu.usa.farm.respositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.farm.entidad.Cliente;
import co.edu.usa.farm.interfaz.ClienteCrudRepositorio;


@Repository
public class ClienteRepositorio {

    
    @Autowired
    private ClienteCrudRepositorio clienteRepoitorio;

    public List<Cliente> getAll(){//Trae toda la tabla de finca
        return (List<Cliente>)clienteRepoitorio.findAll();
    }

    public Optional<Cliente> getCliente(Long idCliente){
        return  clienteRepoitorio.findById(idCliente);
    }

    public Cliente save(Cliente cliente){
        return clienteRepoitorio.save(cliente);
    }

    public Optional<Cliente> getClient(Long idCliente) {
        return clienteRepoitorio.findById(idCliente);
    }

    public void delete(Cliente cliente) {
        clienteRepoitorio.delete(cliente);
    }   
    
}
