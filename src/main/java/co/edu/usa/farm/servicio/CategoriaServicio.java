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
    
    public Optional<Categoria> getCategoria(Long idCategoria){
        return  Crudcategoria.getCategoria(idCategoria);
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

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=Crudcategoria.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return Crudcategoria.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deleteCategoria(Long idCategoria){
        Boolean d=getCategoria(idCategoria).map(categoria -> {
            Crudcategoria.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }

}
