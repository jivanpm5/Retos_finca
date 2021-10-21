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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import co.edu.usa.farm.entidad.Categoria;
import co.edu.usa.farm.servicio.CategoriaServicio;

@RestController
@RequestMapping("/api/Category")
public class CategoriaControlador {
    

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Categoria> getCategoria(){
        return categoriaServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") long id)    {
        return categoriaServicio.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        Categoria f = categoriaServicio.save(categoria);
        return f;
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return categoriaServicio.update(categoria);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long id) {
        return categoriaServicio.deleteCategoria(id);
    }

}
