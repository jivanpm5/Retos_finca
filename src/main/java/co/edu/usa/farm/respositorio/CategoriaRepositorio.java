package co.edu.usa.farm.respositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.farm.entidad.Categoria;
import co.edu.usa.farm.interfaz.CategoriaCrudRepositorio;

@Repository
public class CategoriaRepositorio {
    @Autowired
    private CategoriaCrudRepositorio categoriaRepoitorio;

    public List<Categoria> getAll(){//Trae toda la tabla de finca
        return (List<Categoria>)categoriaRepoitorio.findAll();
    }

    public Optional<Categoria> getCategoria(Long idCategoria){
        return categoriaRepoitorio.findById(idCategoria);
    }

    public Categoria save(Categoria categoria){
        return categoriaRepoitorio.save(categoria);
    }

    public void delete(Categoria categoria){
        categoriaRepoitorio.delete(categoria);
    }

    
}
