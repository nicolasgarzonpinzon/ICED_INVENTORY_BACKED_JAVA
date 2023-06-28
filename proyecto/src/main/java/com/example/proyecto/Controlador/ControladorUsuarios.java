package com.example.proyecto.Controlador;


import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Servicios.ServiciosUsuarios;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorUsuarios {
    private ServiciosUsuarios servicio;

    public  ControladorUsuarios(ServiciosUsuarios servicio){ this.servicio= servicio;}

    @GetMapping("/ListarUsuarios")
    public List<Usuario> listarUsuarios() {
        return servicio.mostrarTodosUsuarios();
    }

    @GetMapping("/BuscarUsuario/{cod}")
    public Usuario BuscarID(@PathVariable("cod") int Usu_Documento){
        return servicio.BuscarUsuario(Usu_Documento);
    }

    @GetMapping("/InsertarUsuario/")
    public String insertarUsuarioo(@RequestBody Usuario usuario){
        return servicio.insertarUsuario(usuario);
    }

    @DeleteMapping("/EliminarUsuario/{Usu_Documento}")
    public String eliminarUsuarioo(@PathVariable("Usu_Documento") String Usu_Documento) {
        return servicio.eliminarUsuario(Usu_Documento);
    }

    @PostMapping("/ActualizarUsuario")
    public String actualizarUsuarioo(@RequestBody Usuario Doc){
        return servicio.actualizarUsuario(Doc);
    }

}

