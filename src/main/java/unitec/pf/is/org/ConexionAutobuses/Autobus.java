package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.data.annotation.Id;

public class Autobus {

    @Id
    private Integer idAutobus;

    String marcaAutobus;
    String tipoAutobus;
    String numeroAsientos;

    public Integer getIdAutobus() {
        return idAutobus;
    }

    //Constructor para buscar por ID

    public Autobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    //Constructor para actualizar

    public Autobus(Integer idAutobus, String marcaAutobus, String tipoAutobus, String numeroAsientos) {
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

    public void setIdAutobus(Integer idAutobus) {
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
