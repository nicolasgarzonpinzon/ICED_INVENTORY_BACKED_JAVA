package com.example.proyecto.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Prestamos")
public class Prestamos {
    @Id
    @Column(unique=true, length = 10)
    private int Pres_Id;
    @Column(unique=true, length = 10)
    private int Pres_Equipos_id;
    @Column(unique = true, length = 10)
    private int Pres_Usuarios_Documento;
    @Column(unique = true, length = 10)
    private Date Pres_Fec_Entrega;
    @Column(unique = true,length = 10)
    private Date Pres_Fec_Devolucion;
    @Column(unique=true, length = 10)
    private Time Pres_Hora_Entrega;
    @Column(unique=true, length = 10)
    private Time Pres_Hora_Devolucion;
    @Column(unique=true, length = 10)
    private int Pres_Tiempo_Limite;
    @Column(unique=true, length = 250)
    private String Pres_Observaciones_entrega;
    @Column(unique=true, length = 250)
    private String Pres_Observaciones_recibido;


    public Prestamos(int pres_Id, int pres_Equipos_id, int pres_Usuarios_Documento, Date pres_Fec_Entrega, Date pres_Fec_Devolucion, Time pres_Hora_Entrega, Time pres_Hora_Devolucion, int pres_Tiempo_Limite, String pres_Observaciones_entrega, String pres_Observaciones_recibido) {
        Pres_Id = pres_Id;
        Pres_Equipos_id = pres_Equipos_id;
        Pres_Usuarios_Documento = pres_Usuarios_Documento;
        Pres_Fec_Entrega = pres_Fec_Entrega;
        Pres_Fec_Devolucion = pres_Fec_Devolucion;
        Pres_Hora_Entrega = pres_Hora_Entrega;
        Pres_Hora_Devolucion = pres_Hora_Devolucion;
        Pres_Tiempo_Limite = pres_Tiempo_Limite;
        Pres_Observaciones_entrega = pres_Observaciones_entrega;
        Pres_Observaciones_recibido = pres_Observaciones_recibido;
    }

    public Prestamos() {
    }


    public int getPres_Id() {
        return Pres_Id;
    }

    public void setPres_Id(int pres_Id) {
        Pres_Id = pres_Id;
    }

    public int getPres_Equipos_id() {
        return Pres_Equipos_id;
    }

    public void setPres_Equipos_id(int pres_Equipos_id) {
        Pres_Equipos_id = pres_Equipos_id;
    }

    public int getPres_Usuarios_Documento() {
        return Pres_Usuarios_Documento;
    }

    public void setPres_Usuarios_Documento(int pres_Usuarios_Documento) {
        Pres_Usuarios_Documento = pres_Usuarios_Documento;
    }

    public Date getPres_Fec_Entrega() {
        return Pres_Fec_Entrega;
    }

    public void setPres_Fec_Entrega(Date pres_Fec_Entrega) {
        Pres_Fec_Entrega = pres_Fec_Entrega;
    }

    public Date getPres_Fec_Devolucion() {
        return Pres_Fec_Devolucion;
    }

    public void setPres_Fec_Devolucion(Date pres_Fec_Devolucion) {
        Pres_Fec_Devolucion = pres_Fec_Devolucion;
    }

    public Time getPres_Hora_Entrega() {
        return Pres_Hora_Entrega;
    }

    public void setPres_Hora_Entrega(Time pres_Hora_Entrega) {
        Pres_Hora_Entrega = pres_Hora_Entrega;
    }

    public Time getPres_Hora_Devolucion() {
        return Pres_Hora_Devolucion;
    }

    public void setPres_Hora_Devolucion(Time pres_Hora_Devolucion) {
        Pres_Hora_Devolucion = pres_Hora_Devolucion;
    }

    public int getPres_Tiempo_Limite() {
        return Pres_Tiempo_Limite;
    }

    public void setPres_Tiempo_Limite(int pres_Tiempo_Limite) {
        Pres_Tiempo_Limite = pres_Tiempo_Limite;
    }

    public String getPres_Observaciones_entrega() {
        return Pres_Observaciones_entrega;
    }

    public void setPres_Observaciones_entrega(String pres_Observaciones_entrega) {
        Pres_Observaciones_entrega = pres_Observaciones_entrega;
    }

    public String getPres_Observaciones_recibido() {
        return Pres_Observaciones_recibido;
    }

    public void setPres_Observaciones_recibido(String pres_Observaciones_recibido) {
        Pres_Observaciones_recibido = pres_Observaciones_recibido;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "Pres_Id=" + Pres_Id +
                ", Pres_Equipos_id=" + Pres_Equipos_id +
                ", Pres_Usuarios_Documento=" + Pres_Usuarios_Documento +
                ", Pres_Fec_Entrega=" + Pres_Fec_Entrega +
                ", Pres_Fec_Devolucion=" + Pres_Fec_Devolucion +
                ", Pres_Hora_Entrega=" + Pres_Hora_Entrega +
                ", Pres_Hora_Devolucion=" + Pres_Hora_Devolucion +
                ", Pres_Tiempo_Limite=" + Pres_Tiempo_Limite +
                ", Pres_Observaciones_entrega='" + Pres_Observaciones_entrega + '\'' +
                ", Pres_Observaciones_recibido='" + Pres_Observaciones_recibido + '\'' +
                '}';
    }
}
