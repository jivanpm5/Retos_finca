package co.edu.usa.farm.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.farm.entidad.Cliente;
import co.edu.usa.farm.respositorio.ClienteRepositorio;

import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio Crudcliente;

    public List<Cliente> getAll(){
        return Crudcliente.getAll();
    }
    
    public Optional<Cliente> getCliente(Long idCliente){
        return  Crudcliente.getCliente(idCliente);
    }

    public Cliente save(Cliente cliente){
        if (cliente.getIdClient()==null) {
            return Crudcliente.save(cliente);
        } else {
            Optional<Cliente> evt=Crudcliente.getCliente(cliente.getIdClient()); 
            if (evt.isEmpty()) {
                return Crudcliente.save(cliente);
                
            } else {
                return cliente;
            }     
        }
    }

    public Cliente update(Cliente cliente) {
        return null;
    }

    public boolean deleteCliente(Long id) {
        return false;
    }
}
