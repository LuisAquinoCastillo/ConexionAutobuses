package unitec.pf.is.org.ConexionAutobuses;

import java.util.concurrent.TimeUnit;
import org.springframework.data.annotation.Id;

public class Roles {

    @Id
    String idRol;
    String terminalOrigen;
    String terminalDestino;
    TimeUnit horaSalida;
    TimeUnit horaLlegada;

    public Roles(){

    }

    public Roles(String idRol, String terminalOrigen, String terminalDestino, TimeUnit horaSalida, TimeUnit horaLlegada) {
        this.idRol = idRol;
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Roles(String terminalOrigen, String terminalDestino, TimeUnit horaSalida, TimeUnit horaLlegada) {
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Roles(String idRol) {
        this.idRol = idRol;
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

    public TimeUnit getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(TimeUnit horaSalida) {
        this.horaSalida = horaSalida;
    }

    public TimeUnit getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(TimeUnit horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
