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
      Resultado: 1 test passed (Process finished with exit code 0)
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

    /*Prueba de caja blanca "Buscar registro por ID"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar un metodo para poder reali-
                 zar la operación de busqueda de los
                 registros por ID.
      Nota: Se utilizara el registro del conductor
            con ID 1001769
      Resultado: 1 test pased (Process finished with exit code 0)
     */
    @Test
    public void buscarId(){

        Conductor respuesta=conductor.findById("1001769").get();
        Assert.assertEquals("1001769",respuesta.getIdConductor());
    }

    /*Prueba de caja blanca "Buscar todos los registros"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar un metodo para poder buscar
                 todos los registros existentes en la
                 base de datos.
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void buscarTodos(){

        int todos=conductor.findAll().size();
        Assert.assertEquals(1,todos);
    }

    /*Prueba de caja blanca "Borrar un registro"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar un metodo para poder borrar
                 un registro de la base de datos.
      Resultado: 1 test passed (Process finished exit code 0)
     */
    @Test
    public void borrar(){

        Conductor c=new Conductor();
        c.setIdConductor("1001769");

        conductor.delete(c);

        int respuesta=conductor.findAll().size();
        Assert.assertEquals(0,respuesta);
    }

     /*
    Fecha: Viernes 13 de Abril del 2018
    Tester: Luis Abraham Aquino Castillo
    Informe final: Se realiza la prueba general a la clase ConductorTest para observar
                   el numero de test completados con exito
    Resultados
            1.- guardar --> test passed
            2.- buscarTodos --> test passed
            3.- actualizar --> test passed
            4.- buscarId --> test falled
            5.- borrar --> test passed
    Conclusiones: El test realizado en el metodo buscar ID reporta falla ya que la organizacion de los metodos
                  esta ordenado de tal manera que el borrado se ejecuta primero y despues la operacion buscarId

                  Se realiza la busqueda individual del metodo buscarId con registro existente y el resultado
                  tiene exito.
     */
}
