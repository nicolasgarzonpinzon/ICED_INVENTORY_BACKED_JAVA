package com.example.proyecto.Servicios;


import com.example.proyecto.Entidad.Usuarios;
import com.example.proyecto.Repositorio.RepositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosUsuarios {
   private RepositorioUsuarios repositorio;

    public ServiciosUsuarios(RepositorioUsuarios repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuarios> mostrarTodosUsuarios() {
        return repositorio.findAll();
    }

    public Usuarios BuscarUsuario(int Usu_Documento) {
        if (repositorio.findById(String.valueOf(Usu_Documento)).isPresent())
            return repositorio.findById(String.valueOf(Usu_Documento)).get();
        else
            return null;
    }




}