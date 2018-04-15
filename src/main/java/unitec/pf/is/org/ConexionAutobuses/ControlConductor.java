package unitec.pf.is.org.ConexionAutobuses;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;



@RestController
@CrossOrigin
@RequestMapping("/api/conductor")
public class ControlConductor {

    @Autowired RepositorioConductor repoConduc;

    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Conductor> buscarTodos(){
        return (ArrayList<Conductor>)repoConduc.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = {"/{idConductor}"},method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Optional<Conductor> buscarPorId(@PathVariable Integer idConductor){
        String id=Integer.toString(idConductor);
        return repoConduc.findById(id);
    }

    @CrossOrigin
    @RequestMapping(value = {"/{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus insertar(@PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apellido_mat,
                            @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        try {
            repoConduc.save(new Conductor(nombre, apellido_pat, apellido_mat, edad, sexo, idAutobus));
        }catch (Exception e){
            return new Estatus(false,"Error: "+e);
        }
        return new Estatus(true, "Guardado con exito");
    }

    @CrossOrigin
    @RequestMapping(value = {"/{idConductor}/{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus actualizar(@PathVariable Integer idConductor, @PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apellido_mat,
                              @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        try {
            String id=Integer.toString(idConductor);
            repoConduc.save(new Conductor(id, nombre, apellido_pat, apellido_mat, edad, sexo, idAutobus));
        }catch (Exception e){
            return new Estatus(false,"Error: ");
        }
        return new Estatus(true, "Actualización exitosa");
    }

    @CrossOrigin
    @RequestMapping(value = {"/{idConductor}/borrar"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus borrar(@PathVariable Integer idConductor){
        try {
            String id=Integer.toString(idConductor);
            repoConduc.delete(new Conductor(id));
        }catch (Exception e){
            return new Estatus(false,"Error: "+e);
        }
        return new Estatus(true, "Borrado exitoso");
    }

    //Metodo JSON para guardar desde la pagina web
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus guardarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Conductor conductor=mapper.readValue(json,Conductor.class);

        repoConduc.save(conductor);
        return new Estatus(true, "Guardado con exito");
    }

    //Metodo JSON para actualizar desde la pagina web
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Conductor conductor=mapper.readValue(json,Conductor.class);

        repoConduc.findById(conductor.getIdAutobus());

        repoConduc.save(conductor);
        return new Estatus(true,"Guardado con exito");
    }

    //Metodo JSON para poder buscar por ID
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Optional<Conductor> buscarIdJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Conductor conductor=mapper.readValue(json,Conductor.class);

        return repoConduc.findById(conductor.getIdAutobus());
    }
}
