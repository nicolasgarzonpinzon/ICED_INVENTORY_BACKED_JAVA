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
    @Column(unique = true, length = 11)
    private int Pres_Id;

    @Column(nullable = false)
    private LocalDate Pres_Fec_Entrega;

    @Column(nullable = false)
    private LocalDate Pres_Fec_Devolucion;

    @Column(nullable = false)
    private Time Pres_Hora_Entrega;

    @Column(nullable = false)
    private Time Pres_Hora_Devolucion;

    @Column(nullable = false, length = 11)
    private int Pres_Tiempo_Limite;

    @Column(nullable = false, length = 250)
    private String Pres_Observaciones_entrega;

    @Column(nullable = false, length = 250)
    private String Pres_Observaciones_recibido;


    @ManyToOne
    @JoinColumn(name = "Pres_Equipos_id")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "Pres_Usuarios_Documento")
    private Usuario usuario;

    @OneToOne(mappedBy = "prestamo")
    private Sancion sancion;

    public Prestamo(int pres_Id, LocalDate pres_Fec_Entrega, LocalDate pres_Fec_Devolucion, Time pres_Hora_Entrega, Time pres_Hora_Devolucion, int pres_Tiempo_Limite, String pres_Observaciones_entrega, String pres_Observaciones_recibido) {
        Pres_Id = pres_Id;
        Pres_Fec_Entrega = pres_Fec_Entrega;
        Pres_Fec_Devolucion = pres_Fec_Devolucion;
        Pres_Hora_Entrega = pres_Hora_Entrega;
        Pres_Hora_Devolucion = pres_Hora_Devolucion;
        Pres_Tiempo_Limite = pres_Tiempo_Limite;
        Pres_Observaciones_entrega = pres_Observaciones_entrega;
        Pres_Observaciones_recibido = pres_Observaciones_recibido;
    }

    public Prestamo() {
    }

    public int getPres_Id() {
        return Pres_Id;
    }

    public void setPres_Id(int pres_Id) {
        Pres_Id = pres_Id;
    }

    public LocalDate getPres_Fec_Entrega() {
        return Pres_Fec_Entrega;
    }

    public void setPres_Fec_Entrega(LocalDate pres_Fec_Entrega) {
        Pres_Fec_Entrega = pres_Fec_Entrega;
    }

    public LocalDate getPres_Fec_Devolucion() {
        return Pres_Fec_Devolucion;
    }

    public void setPres_Fec_Devolucion(LocalDate pres_Fec_Devolucion) {
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
        return "Prestamo{" +
                "Pres_Id=" + Pres_Id +
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
