package unitec.pf.is.org.ConexionAutobuses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControlConductor {

    @Autowired RepositorioConductor repoConduc;

    @CrossOrigin
    @RequestMapping(value = {"/conductor"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Conductor> buscarTodos(){
        return (ArrayList<Conductor>)repoConduc.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = {"/conductor/{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus insertar(@PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apelledp_mat,
                            @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        repoConduc.save(new Conductor(nombre,apellido_pat,apellido_pat,edad,sexo,idAutobus));
        return new Estatus(true, "Guardado con exito");
    }

    @CrossOrigin
    @RequestMapping(value = {"/conductor/{idConductor}/{nombre}/{apellido_pat}/{apellido_mat}/{edad}/{sexo}/{idAutobus}"},
    method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizar(@PathVariable String idConductor, @PathVariable String nombre, @PathVariable String apellido_pat, @PathVariable String apelledp_mat,
                              @PathVariable String edad, @PathVariable String sexo, @PathVariable String idAutobus){
        repoConduc.save(new Conductor(idConductor,nombre,apellido_pat,apelledp_mat,edad,sexo,idAutobus));
        return new Estatus(true, "Actualización exitosa");
    }

}
