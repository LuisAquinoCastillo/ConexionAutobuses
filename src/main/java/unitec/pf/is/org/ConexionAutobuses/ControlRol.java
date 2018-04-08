package unitec.pf.is.org.ConexionAutobuses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value="api/roles")
public class ControlRol {

    @Autowired RepositorioRoles repoRol;

    //Buscar todos los ROLES
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Roles> buscarTodos(){
        return (ArrayList<Roles>)repoRol.findAll();
    }

    //Buscar ROL por ID
    @CrossOrigin
    @RequestMapping(value = {"/{idRol}"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Optional<Roles> buscarPorId( Integer idRol){
        return repoRol.findById(idRol);
    }

    //Guardar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{terminalOrigen}/{terminalDestino}/{horaSalida}/{horaLlegada}"}, method = RequestMethod.GET, headers =
            {"Accept=application/json"})
    public Estatus guardarRol(@PathVariable String terminalOrigen, @PathVariable String terminalDestino, @PathVariable String horaSalida, @PathVariable String horaLlegada ){
        try {
            repoRol.save(new Roles(terminalOrigen, terminalDestino, horaSalida, horaLlegada));
            return new Estatus(true, "Rol guardado con exito");
        }catch (Exception e){
            return new Estatus(false,"Error: "+e);
        }
    }

    //Actualizar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{idRol}/{terminalOrigen}/{terminalDestino}/{horaSalida}/{horaLlegada}"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus actualizarRol(Integer idRol, @PathVariable String terminaOrigen, @PathVariable String terminalDestino,
                                 @PathVariable String horaSalida, @PathVariable String horaLlegada){
        try{
            repoRol.save(new Roles(idRol,terminaOrigen,terminalDestino,horaSalida,horaLlegada));
            return new Estatus(true,"Actualizacion exitosa");
        }catch (Exception e){
            return new Estatus(false, "Erro: "+e);
        }
    }

    //Borrar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{idRol}/borrar"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus borrarRol(Integer idRol){
        try{
            repoRol.delete(new Roles(idRol));
            return new Estatus(true, "Borrado exitoso");
        }catch (Exception e){
            return new Estatus(false, "Error: "+e);
        }
    }

}
