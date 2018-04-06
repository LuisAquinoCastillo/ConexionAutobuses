package unitec.pf.is.org.ConexionAutobuses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value="api/roles")
public class ControlRol {

    @Autowired RepositorioRoles repoRol;

    @CrossOrigin
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public ArrayList<Roles> buscarTodos(){
        return (ArrayList<Roles>)repoRol.findAll();
    }

}
