package unitec.pf.is.org.ConexionAutobuses;

import org.springframework.data.annotation.Id;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Roles {

    @Id
    Integer idRol;
    String terminalOrigen;
    String terminalDestino;
    String horaSalida;

    public Roles(){

    }

    public Roles(Integer idRol) {
        this.idRol = idRol;
    }

    String horaLlegada;

    public Roles(String terminalOrigen, String terminalDestino, String horaSalida, String horaLlegada) {
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Roles(Integer idRol, String terminalOrigen, String terminalDestino, String horaSalida, String horaLlegada) {
        this.idRol = idRol;
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
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