package unitec.pf.is.org.ConexionAutobuses;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConductorTest {

    @Autowired RepositorioConductor conductor;

    /*Prueba de caja blanca "Guardar conductor"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar metodo para poder
                 realizar la prueba de insersion
                 de un registro en la base de da-
                 tos de conductores.
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void guardar(){

        Conductor c=new Conductor();
        c.setIdConductor("1001769");
        c.setNombre("Juan Carlos");
        c.setApellido_pat("Molina");
        c.setApellido_mat("Estrada");
        c.setEdad("43");
        c.setSexo("H");
        c.setIdAutobus("7201");

        Conductor guardar=conductor.save(c);
        Assert.assertEquals(guardar, c);
    }

    /*Prueba de caja blanca "Actualizar conductor"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar metodo para poder actuali-
                 zar un registro de la base de datos
                 de conductores.
      Nota: Se utilizara el registro introducido
            anteriormente.
      Resultado:
     */
    @Test
    public void actualizar(){

        Conductor c=new Conductor();
        c.setIdConductor("1001769");

        conductor.findById(c.idConductor);

        Conductor nuevoConductor=c;
        nuevoConductor.setIdConductor(c.idConductor);
        nuevoConductor.setNombre("Juan Carlos");
        nuevoConductor.setApellido_pat("Molina");
        nuevoConductor.setApellido_mat("Estrada");
        nuevoConductor.setEdad("44");
        nuevoConductor.setSexo("Masculino");
        nuevoConductor.setIdAutobus("7203");

        Conductor respuesta=conductor.save(nuevoConductor);
        Assert.assertEquals(respuesta,nuevoConductor);
    }
}
