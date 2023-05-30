package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.Prestamos;
import com.example.proyecto.Repositorio.RepositorioPrestamos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPrestamos {
    private RepositorioPrestamos repositorio;

    public ServicioPrestamos(RepositorioPrestamos repositorio){
        this.repositorio= repositorio;
    }

    public List<Prestamos> MostrarTodosPrestamos(){
        return repositorio.findAll();
    }
}
