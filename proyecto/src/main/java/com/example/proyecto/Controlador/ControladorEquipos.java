package com.example.proyecto.Controlador;
import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Servicios.ServicioEquipos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEquipos {

    private ServicioEquipos servicio;

    public ControladorEquipos(ServicioEquipos servicio) {
        this.servicio = servicio;
    }
    //llamados de servicios

    @GetMapping("/ListarEquipos")
    public List<Equipo> ListarEquipos(){
        return servicio.mostrarTodos();
    }

    @GetMapping("/Buscar/{cod}")
    public Equipo buscarID(@PathVariable("cod") int Equ_id){
        return servicio.BuscarEquipo(Equ_id);
    }
    @GetMapping("/InsertarEquipo")
    public String insertarEquipoo(@RequestBody Equipo id){
        return servicio.insertarEquipo(id);
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
