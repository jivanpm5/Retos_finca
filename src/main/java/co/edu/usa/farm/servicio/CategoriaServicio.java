package co.edu.usa.farm.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.farm.entidad.Categoria;
import co.edu.usa.farm.respositorio.CategoriaRepositorio;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio Crudcategoria;

    public List<Categoria> getAll(){
        return Crudcategoria.getAll();
    }
    
    public Optional<Categoria> getCategoria(Long idFinca){
        return  Crudcategoria.getCategoria(idFinca);
    }

    public Categoria save(Categoria categoria){
        if (categoria.getId()==null) {
            return Crudcategoria.save(categoria);
        } else {
            Optional<Categoria> evt=Crudcategoria.getCategoria(categoria.getId()); 
            if (evt.isEmpty()) {
                return Crudcategoria.save(categoria);
                
            } else {
                return categoria;
            }     
        }
    }

    public Categoria update(Categoria categoria) {
        return null;
    }

    public boolean deleteCategoria(Long id) {
        return false;
    }
    
}
