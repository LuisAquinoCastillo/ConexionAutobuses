package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value="/api/autobus")
public class ControlAutobus {


    @Autowired RepositorioAutobus repoABus;


    // Metodo para buscar todos los registro
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Autobus> buscarTodos(){
        return (ArrayList<Autobus>)repoABus.findAll();
    }

    //Metodo para buscar por id
    @CrossOrigin
    @RequestMapping(value = {"/{idAutobus}"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Optional<Autobus> buscarPorId (@PathVariable Integer idAutobus){
        String id=Integer.toString(idAutobus);
        return repoABus.findById(id);
    }

    //Metodo para guardar
    @CrossOrigin
    @RequestMapping(value = "/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus guardarAutobus(@PathVariable String marcaAutobus, @PathVariable String tipoAutobus, @PathVariable String numeroAsientos){
        try {
            repoABus.insert(new Autobus(marcaAutobus, tipoAutobus, numeroAsientos));
        }catch (Exception e){
            return new Estatus(false, "Error: "+e);
        }
        return new Estatus(true,"Guardado con exito");
    }

    //Metodo para actualizar
    @CrossOrigin
    @RequestMapping(value = "/{idAutobus}/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizar(@PathVariable Integer idAutobus, @PathVariable String marcaAutobus, @PathVariable String tipoAutobus, @PathVariable String numeroAsientos){
        try {
            String id=Integer.toString(idAutobus);
            repoABus.save(new Autobus(id, marcaAutobus, tipoAutobus, numeroAsientos));
        }catch (Exception e){
            return new Estatus(false,"Error: "+e);
        }
        return new Estatus(true, "Actualizacion con exito");
    }

    //Metodo para borrar registro
    @CrossOrigin
    @RequestMapping(value = "/{idAutobus}/borrar", method = RequestMethod.DELETE, headers = {"Accept=application/json"})
    public Estatus borrarAutobus(@PathVariable Integer idAutobus){
        try {
            String id=Integer.toString(idAutobus);
            repoABus.delete(new Autobus(id));
        }catch (Exception e){
            return new Estatus(false, "Error: "+e);
        }
        return new Estatus(true, "Borrado con exito");
    }

}
