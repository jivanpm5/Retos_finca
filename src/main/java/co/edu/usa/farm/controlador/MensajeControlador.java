package co.edu.usa.farm.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.farm.entidad.Mensaje;
import co.edu.usa.farm.servicio.MensajeServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Message")
public class MensajeControlador {

    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Mensaje> getFinca(){
        return mensajeServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id") long id)    {
        return mensajeServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje finca){
        Mensaje f = mensajeServicio.save(finca);
        return f;
    }
    
}
