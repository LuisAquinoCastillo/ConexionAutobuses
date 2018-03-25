package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.data.annotation.Id;

public class Autobus {

    @Id
    String idAutobus;

    String marcaAutobus;
    String tipoAutobus;
    String numeroAsientos;

    public String getIdAutobus() {
        return idAutobus;
    }

    //Constructor para buscar por ID

    public Autobus(String idAutobus) {
        this.idAutobus = idAutobus;
    }

    //Constructor para actualizar

    public Autobus(String idAutobus, String marcaAutobus, String tipoAutobus, String numeroAsientos) {
        this.idAutobus = idAutobus;
        this.marcaAutobus = marcaAutobus;
        this.tipoAutobus = tipoAutobus;
        this.numeroAsientos = numeroAsientos;
    }

    //Constructor para guardar

    public Autobus(String marcaAutobus, String tipoAutobus, String numeroAsientos) {
        this.marcaAutobus = marcaAutobus;
        this.tipoAutobus = tipoAutobus;
        this.numeroAsientos = numeroAsientos;
    }

    //Getters y Setters

    public void setIdAutobus(String idAutobus) {
        this.idAutobus = idAutobus;
    }

    public String getMarcaAutobus() {
        return marcaAutobus;
    }

    public void setMarcaAutobus(String marcaAutobus) {
        this.marcaAutobus = marcaAutobus;
    }

    public String getTipoAutobus() {
        return tipoAutobus;
    }

    public void setTipoAutobus(String tipoAutobus) {
        this.tipoAutobus = tipoAutobus;
    }

    public String getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(String numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
}
