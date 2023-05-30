package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamos;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ControladorPrestamos {

    private ServicioPrestamos Servicio;

    public ControladorPrestamos(ServicioPrestamos servicio){
        this.Servicio= servicio;
    }

    @GetMapping("/ListarPrestamos")
    public List<Prestamos> listarEquipos(){
        return Servicio.MostrarTodosPrestamos();
    }

}
