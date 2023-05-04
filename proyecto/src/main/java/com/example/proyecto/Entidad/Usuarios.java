package com.example.proyecto.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuarios {
    @Id
    @Column(unique=true, length = 10)
    private int Usu_Documento;

    @Column(nullable = false,length = 40)
    private String Usu_Nombre;

    @Column(nullable = false,length = 40)
    private String Usu_Apellido ;

    @Column(nullable = false,length = 40)
    private String Usu_Tipo;

    @Column(nullable = false,length = 40)
    private String Usu_Celular ;

    @Column(nullable = false,length = 40)
    private String Usu_Correo;

    @Column(nullable = false,length = 40)
    private String Usu_Ficha;


    public Usuarios(int usu_Documento, String usu_Nombre, String usu_Apellido, String usu_Tipo, String usu_Celular, String usu_Correo, String usu_Ficha) {
        Usu_Documento = usu_Documento;
        Usu_Nombre = usu_Nombre;
        Usu_Apellido = usu_Apellido;
        Usu_Tipo = usu_Tipo;
        Usu_Celular = usu_Celular;
        Usu_Correo = usu_Correo;
        Usu_Ficha = usu_Ficha;
    }

    public Usuarios() {
    }

    public int getUsu_Documento() {
        return Usu_Documento;
    }

    public void setUsu_Documento(int usu_Documento) {
        Usu_Documento = usu_Documento;
    }

    public String getUsu_Nombre() {
        return Usu_Nombre;
    }

    public void setUsu_Nombre(String usu_Nombre) {
        Usu_Nombre = usu_Nombre;
    }

    public String getUsu_Apellido() {
        return Usu_Apellido;
    }

    public void setUsu_Apellido(String usu_Apellido) {
        Usu_Apellido = usu_Apellido;
    }

    public String getUsu_Tipo() {
        return Usu_Tipo;
    }

    public void setUsu_Tipo(String usu_Tipo) {
        Usu_Tipo = usu_Tipo;
    }

    public String getUsu_Celular() {
        return Usu_Celular;
    }

    public void setUsu_Celular(String usu_Celular) {
        Usu_Celular = usu_Celular;
    }

    public String getUsu_Correo() {
        return Usu_Correo;
    }

    public void setUsu_Correo(String usu_Correo) {
        Usu_Correo = usu_Correo;
    }

    public String getUsu_Ficha() {
        return Usu_Ficha;
    }

    public void setUsu_Ficha(String usu_Ficha) {
        Usu_Ficha = usu_Ficha;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "Usu_Documento=" + Usu_Documento +
                ", Usu_Nombre='" + Usu_Nombre + '\'' +
                ", Usu_Apellido='" + Usu_Apellido + '\'' +
                ", Usu_Tipo='" + Usu_Tipo + '\'' +
                ", Usu_Celular='" + Usu_Celular + '\'' +
                ", Usu_Correo='" + Usu_Correo + '\'' +
                ", Usu_Ficha='" + Usu_Ficha + '\'' +
                '}';
    }
}
