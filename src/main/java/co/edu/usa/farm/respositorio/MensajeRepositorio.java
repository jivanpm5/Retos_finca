package co.edu.usa.farm.respositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.farm.entidad.Mensaje;
import co.edu.usa.farm.interfaz.MensajeCrudRepositorio;

@Repository
public class MensajeRepositorio {
    @Autowired
    private MensajeCrudRepositorio mensajeRepoitorio;

    public List<Mensaje> getAll(){//Trae toda la tabla de finca
        return (List<Mensaje>)mensajeRepoitorio.findAll();
    }

    public Optional<Mensaje> getMensaje(Long idMensaje){
        return  mensajeRepoitorio.findById(idMensaje);
    }

    public Mensaje save(Mensaje mensaje){
        return mensajeRepoitorio.save(mensaje);
    }

    public Optional<Mensaje> getMessage(Long idMessage) {
        return mensajeRepoitorio.findById(idMessage);
    }

    public void delete(Mensaje mensaje) {
        mensajeRepoitorio.delete(mensaje);
    } 
    
}
