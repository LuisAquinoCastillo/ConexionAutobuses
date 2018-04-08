package unitec.pf.is.org.ConexionAutobuses;

import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRoles extends MongoRepository<Roles, Integer>{
}
