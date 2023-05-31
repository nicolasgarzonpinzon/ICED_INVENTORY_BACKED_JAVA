package com.example.proyecto.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, length = 11)
    private Integer Usu_Documento;

    @Column(nullable = false, length = 100)
    private String Usu_Nombre;

    @Column(nullable = false, length = 100)
    private String Usu_Apellido;

    @Column(nullable = false, length = 100)
    private String Usu_Tipo;

    @Column(nullable = false, length = 100)
    private String Usu_Celular;

    @Column(nullable = false, length = 100)
    private String Usu_Correo;

    @Column(nullable = false, length = 100)
    private String Usu_Ficha;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;

    public Usuario(Integer usu_Documento, String usu_Nombre, String usu_Apellido, String usu_Tipo, String usu_Celular, String usu_Correo, String usu_Ficha, List<Prestamo> prestamos) {
        Usu_Documento = usu_Documento;
        Usu_Nombre = usu_Nombre;
        Usu_Apellido = usu_Apellido;
        Usu_Tipo = usu_Tipo;
        Usu_Celular = usu_Celular;
        Usu_Correo = usu_Correo;
        Usu_Ficha = usu_Ficha;
        this.prestamos = prestamos;
    }

    public Usuario() {
    }

    public Integer getUsu_Documento() {
        return Usu_Documento;
    }

    public void setUsu_Documento(Integer usu_Documento) {
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

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Usu_Documento=" + Usu_Documento +
                ", Usu_Nombre='" + Usu_Nombre + '\'' +
                ", Usu_Apellido='" + Usu_Apellido + '\'' +
                ", Usu_Tipo='" + Usu_Tipo + '\'' +
                ", Usu_Celular='" + Usu_Celular + '\'' +
                ", Usu_Correo='" + Usu_Correo + '\'' +
                ", Usu_Ficha='" + Usu_Ficha + '\'' +
                ", prestamos=" + prestamos +
                '}';
    }


}
