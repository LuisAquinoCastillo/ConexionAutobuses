package unitec.pf.is.org.ConexionAutobuses;


import org.springframework.data.annotation.Id;

public class Roles {

    @Id
    String idRol;
    String terminalOrigen;
    String terminalDestino;
    String horaSalida;

    public Roles(){

    }

    public Roles(String idRol) {
        this.idRol = idRol;
    }

    String horaLlegada;

    public Roles(String terminalOrigen, String terminalDestino, String horaSalida, String horaLlegada) {
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Roles(String idRol, String terminalOrigen, String terminalDestino, String horaSalida, String horaLlegada) {
        this.idRol = idRol;
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getTerminalOrigen() {
        return terminalOrigen;
    }

    public void setTerminalOrigen(String terminalOrigen) {
        this.terminalOrigen = terminalOrigen;
    }

    public String getTerminalDestino() {
        return terminalDestino;
    }

    public void setTerminalDestino(String terminalDestino) {
        this.terminalDestino = terminalDestino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
