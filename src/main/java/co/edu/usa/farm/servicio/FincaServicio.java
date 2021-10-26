package co.edu.usa.farm.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.farm.entidad.Finca;
import co.edu.usa.farm.respositorio.FincaRepositorio;

import java.util.Optional;


@Service
public class FincaServicio {
    @Autowired
    private FincaRepositorio Crudfinca;

    public List<Finca> getAll(){
        return Crudfinca.getAll();
    }
    
    public Optional<Finca> getFinca(Long idFinca){
        return  Crudfinca.getFinca(idFinca);
    }

    public Finca save(Finca finca){
        if (finca.getId()==null) {
            return Crudfinca.save(finca);
        } else {
            Optional<Finca> evt=Crudfinca.getFinca(finca.getId()); 
            if (evt.isEmpty()) {
                return Crudfinca.save(finca);
                
            } else {
                return finca;
            }     
        }
    }
    public Finca update(Finca finca){
        if(finca.getId()!=null){
            Optional<Finca> e=Crudfinca.getFinca(finca.getId());
            if(!e.isEmpty()){
                if(finca.getName()!=null){
                    e.get().setName(finca.getName());
                }
                if(finca.getAddress()!=null){
                    e.get().setAddress(finca.getAddress());
                }
                if(finca.getExtension()!=null){
                    e.get().setExtension(finca.getExtension());
                }
                if(finca.getDescription()!=null){
                    e.get().setDescription(finca.getDescription());
                }
                if(finca.getCategory()!=null){
                    e.get().setCategory(finca.getCategory());
                }
                Crudfinca.save(e.get());
                return e.get();
            }else{
                return finca;
            }
        }else{
            return finca;
        }
    }

    public boolean delete(Long idFinca) {
        Boolean aBoolean = getFinca(idFinca).map(finca -> {
            Crudfinca.delete(finca);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
