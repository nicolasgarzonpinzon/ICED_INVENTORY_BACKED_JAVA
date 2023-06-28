package com.example.proyecto.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, length = 11)
    private int Equ_id;

    @Column(nullable = false, length = 50)
    private String Equi_tipo;

    @Column(nullable = false, length = 50)
    private String Equi_modelo;

    @Column(nullable = false, length = 50)
    private String Equi_color;

    @Column(nullable = false, length = 50)
    private String Equi_serial;

    @Column(nullable = false, length = 50)
    private String Equi_estado;

    @Column(nullable = false, length = 50)
    private String equi_especialidad;

    @OneToMany(mappedBy = "equipo")
    private List<Prestamo> prestamos;


    public Equipo(int equ_id, String equi_tipo, String equi_modelo, String equi_color, String equi_serial, String equi_estado, String equi_especialidad) {
        Equ_id = equ_id;
        Equi_tipo = equi_tipo;
        Equi_modelo = equi_modelo;
        Equi_serial = equi_serial;
        Equi_estado = equi_estado;
        Equi_color = equi_color;
        this.equi_especialidad = equi_especialidad;
    }


    public Equipo() {
    }

    public int getEqu_id() {
        return Equ_id;
    }

    public void setEqu_id(int equ_id) {
        Equ_id = equ_id;
    }

    public String getEqui_tipo() {
        return Equi_tipo;
    }

    public void setEqui_tipo(String equi_tipo) {
        Equi_tipo = equi_tipo;
    }

    public String getEqui_modelo() {
        return Equi_modelo;
    }

    public void setEqui_modelo(String equi_modelo) {
        Equi_modelo = equi_modelo;
    }

    public String getEqui_color() {
        return Equi_color;
    }

    public void setEqui_color(String equi_color) {
        Equi_color = equi_color;
    }

    public String getEqui_serial() {
        return Equi_serial;
    }

    public void setEqui_serial(String equi_serial) {
        Equi_serial = equi_serial;
    }

    public String getEqui_estado() {
        return Equi_estado;
    }

    public void setEqui_estado(String equi_estado) {
        Equi_estado = equi_estado;
    }

    public String getEqui_especialidad() {
        return equi_especialidad;
    }

    public void setEqui_especialidad(String equi_especialidad) {
        this.equi_especialidad = equi_especialidad;
    }

    @Override
    public String toString() {
        return "Equipos{" +
                "Equ_id=" + Equ_id +
                ", Equi_tipo='" + Equi_tipo + '\'' +
                ", Equi_modelo='" + Equi_modelo + '\'' +
                ", Equi_color='" + Equi_color + '\'' +
                ", Equi_serial='" + Equi_serial + '\'' +
                ", Equi_estado='" + Equi_estado + '\'' +
                ", equi_especialidad='" + equi_especialidad + '\'' +
                '}';
    }
}
