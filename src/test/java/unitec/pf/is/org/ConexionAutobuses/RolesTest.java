package unitec.pf.is.org.ConexionAutobuses;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolesTest {

    @Autowired RepositorioRoles roles;

    /*Prueba de caja blanca "Guardar Rol"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar metodo para poder
                 realizar la prueba de insersion
                 de un registro en la base de da-
                 tos de roles.
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void guardar(){

        Roles r=new Roles();
        r.setIdRol("1");
        r.setTerminalOrigen("MEX");
        r.setTerminalDestino("OAX");
        r.setHoraSalida("10:30 am");
        r.setHoraLlegada("5:30 pm");

        Roles guardar=roles.save(r);
        Assert.assertEquals(guardar,r);
    }

    /*Prueba de caja blanca "Actualizar Rol"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar metodo para poder actuali-
                 zar un registro de la base de datos
                 de roles.
      Nota: Se utilizara el registro introducido
            anteriormente.
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void actualizar(){

        Roles r=new Roles();
        r.setIdRol("1");

        roles.findById(r.idRol);

        Roles nuevoRol=new Roles();
        nuevoRol.setIdRol(r.idRol);
        nuevoRol.setTerminalOrigen("PUE");
        nuevoRol.setTerminalDestino("XAP");
        nuevoRol.setHoraSalida("6:00 am");
        nuevoRol.setHoraLlegada("----");

        Roles respuesta=roles.save(nuevoRol);
        Assert.assertEquals(respuesta,nuevoRol);
    }

    /*Prueba de caja blanca "Buscar registro por ID"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar un metodo para poder reali-
                 zar la operación de busqueda de los
                 registros por ID.
      Nota: Se utilizara el registro del rol
            con ID 1
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void buscarId(){

        Roles respuesta=roles.findById("1").get();
        Assert.assertEquals("1",respuesta.getIdRol());
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

        int rolesTotales=roles.findAll().size();
        Assert.assertEquals(1,rolesTotales);
    }

    /*Prueba de caja blanca "Borrar un registro"
      Fecha: Viernes 13 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisito: Realizar un metodo para poder borrar
                 un registro de la base de datos.
      Resultado: 1 test passed (Process finished with exit code 0)
     */
    @Test
    public void borrar(){

        Roles r=new Roles();
        r.setIdRol("1");

        roles.delete(r);

        int respuesta=roles.findAll().size();
        Assert.assertEquals(0,respuesta);
    }

    /*
    Fecha: Viernes 13 de Abril del 2018
    Tester: Luis Abraham Aquino Castillo
    Informe final: Se realiza la prueba general a la clase RolesTest para observar
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
