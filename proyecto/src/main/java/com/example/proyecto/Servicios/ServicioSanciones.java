package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.Sancion;
import com.example.proyecto.Repositorio.RepositorioSanciones;

import java.util.List;

public class ServicioSanciones {
    private RepositorioSanciones repositorio;

    public ServicioSanciones(RepositorioSanciones repositorio){
        this.repositorio=repositorio;
    }
    public List<Sancion>MostrarTodosSanciones(){
        return repositorio.findAll();
    }
}
