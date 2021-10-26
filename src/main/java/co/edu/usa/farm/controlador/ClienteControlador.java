package co.edu.usa.farm.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import co.edu.usa.farm.entidad.Cliente;
import co.edu.usa.farm.servicio.ClienteServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Cliente> getCliente(){
        return clienteServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") long clientId)    {
        return clienteServicio.getCliente(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        Cliente f = clienteServicio.save(cliente);
        return f;
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteServicio.update(cliente);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long clientId) {
        return clienteServicio.delete(clientId);
    }
    
}
