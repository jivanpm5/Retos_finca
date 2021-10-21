package co.edu.usa.farm.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.farm.entidad.Mensaje;
import co.edu.usa.farm.respositorio.MensajeRepositorio;

import java.util.Optional;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepositorio Crudmensaje;

    public List<Mensaje> getAll(){
        return Crudmensaje.getAll();
    }
    
    public Optional<Mensaje> getMensaje(Long idMensaje){
        return  Crudmensaje.getMensaje(idMensaje);
    }

    public Mensaje save(Mensaje mensaje){
        if (mensaje.getIdMessage()==null) {
            return Crudmensaje.save(mensaje);
        } else {
            Optional<Mensaje> evt=Crudmensaje.getMensaje(mensaje.getIdMessage()); 
            if (evt.isEmpty()) {
                return Crudmensaje.save(mensaje);
                
            } else {
                return mensaje;
            }     
        }
    }

    public Mensaje update(Mensaje finca) {
        return null;
    }

    public boolean deleteMensaje(Long id) {
        return false;
    }
    
}
