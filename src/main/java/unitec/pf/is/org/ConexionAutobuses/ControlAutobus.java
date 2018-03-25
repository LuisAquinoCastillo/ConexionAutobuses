package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControlAutobus {

    @Autowired RepositorioAutobus repoABus;


    // Metodo para buscar todos los registros
    @CrossOrigin
    @RequestMapping(value = "/autobus", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Autobus> buscarTodos(){
        return (ArrayList<Autobus>)repoABus.findAll();
    }

    //Metodo para guardar
    @CrossOrigin
    @RequestMapping(value = "/autobus/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus guardarAutobus(@PathVariable String marcaAutobus, @PathVariable String tipoAutobus, @PathVariable String numeroAsientos){
        repoABus.save(new Autobus(marcaAutobus, tipoAutobus, numeroAsientos));
        return new Estatus(true,"Guardado con exito");
    }

    //Metodo para actualizar
    @CrossOrigin
    @RequestMapping(value = "/autobus/{idAutobus}/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizar(@PathVariable String idAutobus, @PathVariable String marcaAutobus, @PathVariable String tipoAutobus, @PathVariable String numeroAsientos){
        repoABus.save(new Autobus(idAutobus,marcaAutobus,tipoAutobus,numeroAsientos));
        return new Estatus(true, "Actualizacion con exito");
    }

    //Metodo para borrar registro
    @CrossOrigin
    @RequestMapping(value = "/autobus/{idAutobus}", method = RequestMethod.DELETE, headers = {"Accept=application/json"})
    public Estatus borrarAutobus(@PathVariable String idAutobus){
        repoABus.delete(new Autobus(idAutobus));
        return new Estatus(true, "Borrado con exito");
    }

}
