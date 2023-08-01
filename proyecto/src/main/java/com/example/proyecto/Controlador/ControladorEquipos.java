package com.example.proyecto.Controlador;
import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Servicios.ServicioEquipos;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listarEquipos")
    public List<Equipo> ListarEquipos() {
        return servicio.mostrarTodos();
    }
    @GetMapping("/BuscarEquipo/{cod}")
    public ResponseEntity<?> buscarID(@PathVariable("cod") int Equ_id){
        return servicio.buscarEquipo(Equ_id);
    }

    @PostMapping("/insertarEquipo")
    public String insertar_cli(@RequestBody Equipo user){
        return servicio.insertaEquipo(user);
    }
    @DeleteMapping("/Eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") String codigo) {
        return servicio.eliminarEquipo(codigo);
    }

    @PostMapping("/ActualizarEquipo/")
    public String actualizarProductos(@RequestBody Equipo E){
        return servicio.actualizarEquipo(E);
    }
}
