package co.edu.usa.farm.respositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.farm.entidad.Finca;
import co.edu.usa.farm.interfaz.FincaCrudRepositorio;

@Repository
public class FincaRepositorio {
    @Autowired
    private FincaCrudRepositorio fincaRepoitorio;

    public List<Finca> getAll(){//Trae toda la tabla de finca
        return (List<Finca>)fincaRepoitorio.findAll();
    }

    public Optional<Finca> getFinca(Long idFinca){
        return  fincaRepoitorio.findById(idFinca);
    }

    public Finca save(Finca finca){
        return fincaRepoitorio.save(finca);
    }

    public void delete(Finca finca) {
        fincaRepoitorio.delete(finca);
    }   
}
