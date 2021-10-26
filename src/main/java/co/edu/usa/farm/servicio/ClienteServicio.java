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

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= Crudcliente.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                Crudcliente.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(Long clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            Crudcliente.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}