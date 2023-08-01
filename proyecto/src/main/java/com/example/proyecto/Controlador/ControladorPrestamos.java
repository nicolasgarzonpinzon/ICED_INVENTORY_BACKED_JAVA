package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "*")
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
    @PostMapping("/insertarPrestamo/{Eq}/{Us}")
    public String insertar_Prestamoo(@PathVariable("Eq") String Eq, @PathVariable("Us") String Us,@RequestBody Prestamo prestamo) {
        return Servicio.insertarPrestamo(Eq, Us, prestamo);
    }

    @PostMapping("/ActualizarPrestamo/")
    public String actualizarPrestamoo(@RequestBody Prestamo id){
        return Servicio.actualizarPrestamo(id);
    }



}
