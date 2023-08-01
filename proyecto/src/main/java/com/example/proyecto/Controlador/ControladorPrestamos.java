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
    @PostMapping("/insertarPrestamo")
    public String insertar_Prestamoo(@RequestBody Prestamo prestamo) {
        // Obtener documentoUsuario y idEquipo del objeto prestamo
        String documentoUsuario = String.valueOf(prestamo.getUsu_Documento_usurios()); // Asumiendo que hay un método getter en la clase Prestamo para obtener el documentoUsuario
        String idEquipo = String.valueOf(prestamo.getEqu_id_equipos()); // Asumiendo que hay un método getter en la clase Prestamo para obtener el idEquipo

        // Llamar al método del servicio con los parámetros adecuados
        return Servicio.insertarPrestamo(documentoUsuario, idEquipo, prestamo);
    }

    @PostMapping("/ActualizarPrestamo/")
    public String actualizarPrestamoo(@RequestBody Prestamo id){
        return Servicio.actualizarPrestamo(id);
    }



}
