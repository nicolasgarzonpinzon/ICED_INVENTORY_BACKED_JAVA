package com.example.proyecto.Controlador;
import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Servicios.ServicioEquipos;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEquipos {

    private ServicioEquipos servicio;

    public ControladorEquipos(ServicioEquipos servicio) {
        this.servicio = servicio;
    }
    //llamados de servicios

     @GetMapping("/listarequipos")
    public List<Equipo> ListarEquipos( ) {
        List<Equipo> equipos = servicio.mostrarTodos();
        return equipos;
    }

    @GetMapping("/Buscar/{cod}")
    public Equipo buscarID(@PathVariable("cod") int Equ_id){
        return servicio.BuscarEquipo(Equ_id);
    }
    @PostMapping("/InsertarEquipo")
    public String insertarEquipoo(@RequestBody Equipo equipo) {
        return servicio.insertarEquipo(equipo);
    }


    @DeleteMapping("/Eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") String codigo) {
        return servicio.eliminarEquipo(codigo);
    }

    @PostMapping("/ActualizarEquipo")
    public String actualizarProductos(@RequestBody Equipo E){
        return servicio.actualizarEquipo(E);
    }
}
