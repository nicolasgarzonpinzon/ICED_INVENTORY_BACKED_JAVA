package com.example.proyecto.Entidad;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pres_Id")
    private int presId;

    @Column(nullable = false, name = "Pres_Fec_Entrega")
    private LocalDate fechaEntrega;

    @Column(nullable = false, name = "Pres_Tiempo_Limite")
    private int tiempoLimite;

    @Column(nullable = false, name = "Pres_Observaciones_entrega", length = 250)
    private String observacionesEntrega;

    @ManyToOne
    @JoinColumn(name = "Pres_Equipos_id")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "Pres_Usuarios_Documento")
    private Usuario usuario;

    @OneToOne(mappedBy = "prestamo")
    private Sancion sancion;

    public Prestamo(int presId, LocalDate fechaEntrega,int tiempoLimite, String observacionesEntrega) {
        this.presId = presId;
        this.fechaEntrega = fechaEntrega;
        this.tiempoLimite = tiempoLimite;
        this.observacionesEntrega = observacionesEntrega;

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
                ", tiempoLimite=" + tiempoLimite +
                ", observacionesEntrega='" + observacionesEntrega + '\'' +
                '}';
    }
}
