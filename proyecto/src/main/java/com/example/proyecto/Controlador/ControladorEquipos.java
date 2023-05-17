package com.example.proyecto.Controlador;
import com.example.proyecto.Entidad.Equipos;
import com.example.proyecto.Servicios.ServicioEquipos;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorEquipos {

    private ServicioEquipos servicio;

    public ControladorEquipos(ServicioEquipos servicio) {
        this.servicio = servicio;
    }

    //lamados de servicios

    @GetMapping("/listarEquipos")
    public List<Equipos> ListarEquipos(){
        return servicio.mostrarTodos();
    }

    @GetMapping("/buscar/{cod}")
    public Equipos buscarID(@PathVariable("cod") int Equ_id){
        return servicio.BuscarUsuario(Equ_id);
    }



    @DeleteMapping("/Eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") String codigo) {
        return servicio.eliminar(codigo);
    }


}