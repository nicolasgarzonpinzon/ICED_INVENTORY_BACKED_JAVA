package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ControladorPrestamos {

    private ServicioPrestamos Servicio;

    public ControladorPrestamos(ServicioPrestamos servicio){
        this.Servicio= servicio;
    }

    @GetMapping("/ListarPrestamos")
    public List<Prestamo> listarPrestamos(){
        return Servicio.MostrarTodosPrestamos();
    }

    @GetMapping("/BuscarPrestamo/{codigo}")
    public Prestamo buscarPrestamoID(@PathVariable("codigo") int San_Pres_Id){
        return Servicio.BuscarSancion(San_Pres_Id);
    }

    @DeleteMapping("/EliminarPrestamo/{codigo}")
    public String eliminarPrestamo(@PathVariable("codigo") String San_Pres_Id) {
        return Servicio.eliminarPrestamo(San_Pres_Id);
    }

    @PostMapping("/ActualizarPrestamo")
    public String actualizarPrestamoo(@RequestBody Prestamo id){
        return Servicio.actualizarPrestamo(id);
    }

    @PostMapping("/InsertarPrestamo/")
    public String insertarPrestamo(@RequestBody Prestamo prestamo){
        return Servicio.insertarPrestamo(prestamo);
    }



}
