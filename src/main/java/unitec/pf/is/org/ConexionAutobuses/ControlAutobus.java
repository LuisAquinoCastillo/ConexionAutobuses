package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    //Metodo para buscar por id
    @CrossOrigin
    @RequestMapping(value = "/autobus/{idAutobus}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public Autobus buscarPorId(Integer idAutobus){
        return repoABus.findOne(idAutobus);
    }

}
