package unitec.pf.is.org.ConexionAutobuses;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AutobusesTest {

    @Autowired RepositorioAutobus autobus;

    /*Prueba de caja blanca "Guardar registro"
      Fecha: Miercoles 12 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisitos: Para poder realizar la prueba es
                    necesario realizar un metodo con
                    el etiquetado @Test para realizar
                    la prueba.
      Resultado: 1 test passed (Process finished with exit code 0).
      */
    @Test
    public void guardar(){

        Autobus u = new Autobus();

        u.setIdAutobus("7201");
        u.setMarcaAutobus("ADO platino");
        u.setTipoAutobus("Irizar i8: 3 ejes");
        u.setNumeroAsientos("25");

        Autobus guardar=autobus.save(u);
        Assert.assertEquals(guardar, u);

    }

    /*Prueba de caja blanca "Actualizar registro"
      Fecha: Miercoles 12 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisitos: Realizar metodo donde se pueda
                  realizar la operación de
                  actualizar.
      Nota: Recuperaremos el registro antes intro-
            ducido con id "7201"
      Resultado: 1 test passed (Process finished with exit code 0).
     */
    @Test
    public void actualizar(){

        Autobus busqueda=new Autobus();
        busqueda.setIdAutobus("7201");
        autobus.delete(busqueda);

        Autobus u=new Autobus();
        u.setIdAutobus("7201");
        u.setMarcaAutobus("ADO platino");
        u.setTipoAutobus("Volvo v3: 3 ejes");
        u.setNumeroAsientos("20");

        Autobus actualizar=autobus.save(u);
        Assert.assertEquals(actualizar, u);
    }

    /*Prueba de caja blanca "Borrar registro"
      Fecha: Miercoles 12 de Abril del 2018
      Tester: Luis Abraham Aquino Castillo
      Requisitos: Realizar metodo donde se
                  pueda realizar la operación
                  de borrar buscando el regis-
                  tro mediante el id.
      Nota: Recuperaremos el registro con el
            id "7201".
      Resultado: 1 test passed (Process finished with exit code 0).
     */
    @Test
    public void borrar(){

        Autobus id=new Autobus();
        id.setIdAutobus("7201");
        autobus.delete(id);

    }
}
