package co.edu.usa.farm.controlador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.farm.entidad.Finca;
import co.edu.usa.farm.servicio.FincaServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class FincaControlador {

    @GetMapping("/holamundo")
    public String saludar(){
        return "Hola Mundo, si funciona";
    }

    @Autowired
    private FincaServicio fincaServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Finca> getFinca(){
        return fincaServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Finca> getFinca(@PathVariable("id") long fincaId)    {
        return fincaServicio.getFinca(fincaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Finca save(@RequestBody Finca finca){
        Finca f = fincaServicio.save(finca);
        return f;
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Finca update(@RequestBody Finca finca) {
        return fincaServicio.update(finca);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long fincaId) {
        return fincaServicio.delete(fincaId);
    }
}