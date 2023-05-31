package com.example.proyecto.Controlador;


import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Servicios.ServiciosUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorUsuarios {
    private ServiciosUsuarios servicio;

    public  ControladorUsuarios(ServiciosUsuarios servicio){ this.servicio= servicio;}

    @GetMapping("/ListarUsuarios")
    public List<Usuario> ListarUsuarios(){
        return servicio.mostrarTodosUsuarios();
    }

    @GetMapping("/Buscar/{cod}")
    public Usuario BuscarID(@PathVariable("cod") int Usu_Documento){
        return servicio.BuscarUsuario(Usu_Documento);
    }





}

