package unitec.pf.is.org.ConexionAutobuses;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
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
    public Optional<Roles> buscarPorId( @PathVariable Integer idRol){
        String id=Integer.toString(idRol);
        return repoRol.findById(id);
    }

    //Guardar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{terminalOrigen}/{terminalDestino}/{horaSalida}/{horaLlegada}/{diasDisponibles}"}, method = RequestMethod.GET, headers =
            {"Accept=application/json"})
    public Estatus guardarRol(@PathVariable String terminalOrigen, @PathVariable String terminalDestino, @PathVariable String horaSalida, @PathVariable String horaLlegada,
                              @PathVariable String diasDisponibles){
        try {
            repoRol.save(new Roles(terminalOrigen, terminalDestino, horaSalida, horaLlegada,diasDisponibles));
        }catch (Exception e){
            return new Estatus(false,"Error: "+e);
        }
        return new Estatus(true, "Rol guardado con exito");
    }

    //Actualizar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{idRol}/{terminalOrigen}/{terminalDestino}/{horaSalida}/{horaLlegada}"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus actualizarRol(@PathVariable Integer idRol, @PathVariable String terminalOrigen, @PathVariable String terminalDestino,
                                 @PathVariable String horaSalida, @PathVariable String horaLlegada, @PathVariable String diasDisponibles){
        try{
            String id=Integer.toString(idRol);
            repoRol.save(new Roles(id,terminalOrigen,terminalDestino,horaSalida,horaLlegada,diasDisponibles));
        }catch (Exception e){
            return new Estatus(false, "Erro: "+e);
        }
        return new Estatus(true,"Actualizacion exitosa");
    }

    //Borrar ROL
    @CrossOrigin
    @RequestMapping(value = {"/{idRol}/borrar"}, method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Estatus borrarRol(@PathVariable Integer idRol){
        try{
            String id=Integer.toString(idRol);
            repoRol.delete(new Roles(id));
        }catch (Exception e){
            return new Estatus(false, "Error: "+e);
        }
        return new Estatus(true, "Borrado exitoso");
    }

    //Metodo JSON para guardar
    @CrossOrigin
    @RequestMapping(value = {"/"},method = RequestMethod.POST, headers = {"Accept=application/json"})
    public Estatus guardarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Roles roles=mapper.readValue(json, Roles.class);

        repoRol.save(roles);
        return new Estatus(true,"Guardado con exito");
    }

    //Metodo JSON para actualizar
    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT, headers = {"Accept=application/json"})
    public Estatus actualizarJSON(@RequestBody String json)throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Roles roles=mapper.readValue(json,Roles.class);

        repoRol.findById(roles.getIdRol());

        repoRol.save(roles);
        return new Estatus(true,"Actualizado con exito");
    }



}
