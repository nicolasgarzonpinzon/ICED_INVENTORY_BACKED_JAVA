package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ControladorPrestamos {

    private ServicioPrestamos Servicio;

    public ControladorPrestamos(ServicioPrestamos servicio){
        this.Servicio= servicio;
    }

    @GetMapping("/ListarPrestamos")
    public List<Prestamo> listarPrestamos(){
        return Servicio.MostrarTodosPrestamos();
    }

    @GetMapping("/buscarPrestamo/{codigo}")
    public Prestamo buscarPrestamoID(@PathVariable("codigo") int San_Pres_Id){
        return Servicio.BuscarSancion(San_Pres_Id);
    }

    @DeleteMapping("/EliminarPrestamo/{codigo}")
    public String eliminarPrestamo(@PathVariable("codigo") String San_Pres_Id) {
        return Servicio.eliminarPrestamo(San_Pres_Id);
    }

}
