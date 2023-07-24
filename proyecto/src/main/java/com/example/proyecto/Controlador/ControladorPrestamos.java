package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/BuscarPrestamo/{cod}")
    public ResponseEntity<?> buscarID(@PathVariable("cod") int PresId){
        return Servicio.buscarPrestamo(PresId);
    }
    @DeleteMapping("/EliminarPrestamo/{presId}")
    public String eliminarUsuarioo(@PathVariable("presId") String id) {
        return Servicio.eliminarPrestamo(id);
    }
    @PostMapping("/InsertarPrestamo/")
    public String insertarPrestamoo(@RequestBody Prestamo prestamo){
        return Servicio.insertarPrestamo(prestamo);
    }
    @PostMapping("/ActualizarPrestamo/")
    public String actualizarPrestamoo(@RequestBody Prestamo id){
        return Servicio.actualizarPrestamo(id);
    }



}
