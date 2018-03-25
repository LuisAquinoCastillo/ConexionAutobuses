package unitec.pf.is.org.ConexionAutobuses;

public class Estatus {

    private boolean success;
    private String respuesta;

    public Estatus(boolean success, String respuesta) {
        this.success = success;
        this.respuesta = respuesta;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
