package unitec.pf.is.org.ConexionAutobuses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;



@RestController
@CrossOrigin
@RequestMapping(value="/api/conductor",method = RequestMethod.TRACE)
public class ControlConductor {

    @Autowired RepositorioConductor repoConduc;

    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Conductor> buscarTodos(){
        return (ArrayList<Conductor>)repoConduc.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = {"{idConductor}"},method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Optional<Conductor> buscarPorId(@PathVariable String idConductor){
        return repoConduc.findById(idConductor);
    }

    @CrossOrigin
    @RequestMapping(value = {"{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus insertar(@PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apellido_mat,
                            @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        repoConduc.save(new Conductor(nombre,apellido_pat,apellido_mat,edad,sexo,idAutobus));
        return new Estatus(true, "Guardado con exito");
    }

    @CrossOrigin
    @RequestMapping(value = {"{idConductor}/{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizar(@PathVariable String idConductor, @PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apellido_mat,
                              @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        repoConduc.save(new Conductor(idConductor,nombre,apellido_pat,apellido_mat,edad,sexo,idAutobus));
        return new Estatus(true, "Actualización exitosa");
    }

    @CrossOrigin
    @RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE, headers = {"Accept=application/json"})
    public Estatus borrar(@PathVariable String id){
        repoConduc.delete(new Conductor(id));
        return new Estatus(true, "Borrado exitoso");
    }
}
