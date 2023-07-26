package com.example.proyecto.Entidad;

import jakarta.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;


@Entity
@Table(name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer presId;


    @Column(name = "Pres_Fec_Entrega")
    @Temporal(TemporalType.DATE)
    private Date Pres_Fec_Entrega;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Equ_id", referencedColumnName = "Equ_id", nullable = false)
    @JsonIgnore
    public Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usu_Documento", referencedColumnName = "Usu_Documento", nullable = false)
    @JsonIgnore
    public Usuario usuario;


    @PrePersist
    public void fechaActual() {

        this.Pres_Fec_Entrega = new Date();
    }

    public Prestamo(Integer presId, Date pres_Fec_Entrega, Equipo equipo, Usuario usuario) {
        this.presId = presId;
        Pres_Fec_Entrega = pres_Fec_Entrega;
        this.equipo = equipo;
        this.usuario = usuario;
    }

    public Prestamo() {
    }

    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
    }

    public Date getPres_Fec_Entrega() {
        return Pres_Fec_Entrega;
    }

    public void setPres_Fec_Entrega(Date pres_Fec_Entrega) {
        Pres_Fec_Entrega = pres_Fec_Entrega;
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

    @Override
    public String toString() {
        return "Prestamo{" +
                "presId=" + presId +
                ", Pres_Fec_Entrega=" + Pres_Fec_Entrega +
                ", equipo=" + equipo +
                ", usuario=" + usuario +
                '}';
    }
}
