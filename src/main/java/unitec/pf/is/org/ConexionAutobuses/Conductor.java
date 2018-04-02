package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "conductor")
public class Conductor {

    @Id
    String idConductor;

    public Conductor(){

    }

    public Conductor(String idConductor) {
        this.idConductor = idConductor;
    }

    String nombre;
    String apellido_pat;
    String apellido_mat;
    String edad;
    String sexo;
    String idAutobus;

    public Conductor(String nombre, String apellido_pat, String apellido_mat, String edad, String sexo, String idAutobus) {
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.edad = edad;
        this.sexo = sexo;
        this.idAutobus = idAutobus;
    }

    public Conductor(String idConductor, String nombre, String apellido_pat, String apellido_mat, String edad, String sexo, String idAutobus) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.edad = edad;
        this.sexo = sexo;
        this.idAutobus = idAutobus;
    }

    //Getters y Setters para los campos de la colección de los consuctores
    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(String idAutobus) {
        this.idAutobus = idAutobus;
    }
}