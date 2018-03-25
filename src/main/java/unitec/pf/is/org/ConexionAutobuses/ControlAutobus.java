package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
