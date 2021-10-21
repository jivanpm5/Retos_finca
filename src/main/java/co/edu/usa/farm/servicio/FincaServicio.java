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

    public Finca update(Finca finca) {
        return null;
    }

    public boolean deleteFinca(Long id) {
        return false;
    }
}
