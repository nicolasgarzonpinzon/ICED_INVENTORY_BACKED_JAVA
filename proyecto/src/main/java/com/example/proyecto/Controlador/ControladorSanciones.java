package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Sancion;
import com.example.proyecto.Servicios.ServicioSanciones;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ControladorSanciones {

    private ServicioSanciones servicio;

    public ControladorSanciones(ServicioSanciones servicio){
        this.servicio=servicio;
    }
    @GetMapping("/listarSanciones")
    public List<Sancion>listarSancio(){
        return servicio.MostrarTodosSanciones();
    }
}
