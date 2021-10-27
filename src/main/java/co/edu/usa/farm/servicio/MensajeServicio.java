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
    
    public Mensaje update(Mensaje mensaje){
        if(mensaje.getIdMessage()!=null){
            Optional<Mensaje> e= Crudmensaje.getMessage(mensaje.getIdMessage());
            if(!e.isEmpty()){
                if(mensaje.getMessageText()!=null){
                    e.get().setMessageText(mensaje.getMessageText());
                }
                Crudmensaje.save(e.get());
                return e.get();
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }
    }
    
    public boolean deleteMensaje(Long idMensaje) {
        Boolean aBoolean = getMensaje(idMensaje).map(mensaje -> {
            Crudmensaje.delete(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
