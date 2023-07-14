package com.example.proyecto.Entidad;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pres_Id")
    private int presId;

    @Column(nullable = false, name = "Pres_Fec_Entrega")
    private LocalDate fechaEntrega;

    @Column(nullable = false, name = "Pres_Fec_Devolucion")
    private LocalDate fechaDevolucion;

    @Column(nullable = false, name = "Pres_Hora_Entrega")
    private Time horaEntrega;

    @Column(nullable = false, name = "Pres_Hora_Devolucion")
    private Time horaDevolucion;

    @Column(nullable = false, name = "Pres_Tiempo_Limite")
    private int tiempoLimite;

    @Column(nullable = false, name = "Pres_Observaciones_entrega", length = 250)
    private String observacionesEntrega;

    @Column(nullable = false, name = "Pres_Observaciones_recibido", length = 250)
    private String observacionesRecibido;

    @ManyToOne
    @JoinColumn(name = "Pres_Equipos_id")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "Pres_Usuarios_Documento")
    private Usuario usuario;

    @OneToOne(mappedBy = "prestamo")
    private Sancion sancion;

    public Prestamo(int presId, LocalDate fechaEntrega, LocalDate fechaDevolucion, Time horaEntrega, Time horaDevolucion, int tiempoLimite, String observacionesEntrega, String observacionesRecibido) {
        this.presId = presId;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
        this.horaEntrega = horaEntrega;
        this.horaDevolucion = horaDevolucion;
        this.tiempoLimite = tiempoLimite;
        this.observacionesEntrega = observacionesEntrega;
        this.observacionesRecibido = observacionesRecibido;
    }

    public Prestamo() {
    }

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Time getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public String getObservacionesEntrega() {
        return observacionesEntrega;
    }

    public void setObservacionesEntrega(String observacionesEntrega) {
        this.observacionesEntrega = observacionesEntrega;
    }

    public String getObservacionesRecibido() {
        return observacionesRecibido;
    }

    public void setObservacionesRecibido(String observacionesRecibido) {
        this.observacionesRecibido = observacionesRecibido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sancion getSancion() {
        return sancion;
    }

    public void setSancion(Sancion sancion) {
        this.sancion = sancion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "presId=" + presId +
                ", fechaEntrega=" + fechaEntrega +
                ", fechaDevolucion=" + fechaDevolucion +
                ", horaEntrega=" + horaEntrega +
                ", horaDevolucion=" + horaDevolucion +
                ", tiempoLimite=" + tiempoLimite +
                ", observacionesEntrega='" + observacionesEntrega + '\'' +
                ", observacionesRecibido='" + observacionesRecibido + '\'' +
                '}';
    }
}
