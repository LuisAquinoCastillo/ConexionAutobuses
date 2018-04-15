package unitec.pf.is.org.ConexionAutobuses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.GET, headers = {"Accept=application/json"})
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
    @RequestMapping(value = "/{idAutobus}/{marcaAutobus}/{tipoAutobus}/{numeroAsientos}", method = RequestMethod.GET, headers = {"Accept=application/json"})
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
    @RequestMapping(value = "/{idAutobus}/borrar", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus borrarAutobus(@PathVariable Integer idAutobus){
        try {
            String id=Integer.toString(idAutobus);
            repoABus.delete(new Autobus(id));
        }catch (Exception e){
            return new Estatus(false, "Error: "+e);
        }
        return new Estatus(true, "Borrado con exito");
    }

    //Guardar
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus guardarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Autobus autobus=mapper.readValue(json,Autobus.class);

        repoABus.save(autobus);
        return new Estatus(true,"Guardado con exito");

    }

    //Actualizar
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus  actualizarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Autobus autobus=mapper.readValue(json,Autobus.class);

        repoABus.findById(autobus.getIdAutobus());

        repoABus.save(autobus);
        return new Estatus(true,"Actualizado con exito");
    }

    //Borrar
    @CrossOrigin
    @RequestMapping(value = {"/borrar"}, method = RequestMethod.DELETE, headers = {"Accept=application/json"})
    public Estatus borrarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Autobus autobus=mapper.readValue(json,Autobus.class);

        repoABus.delete(autobus);
        return new Estatus(true,"Borrado con exito");
    }

}
