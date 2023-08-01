package com.example.proyecto.Controlador;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Servicios.ServiciosUsuarios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<?> BuscarID(@PathVariable("cod") int Usu_Documento){
        return servicio.BuscarUsuario(Usu_Documento);
    }

    @PostMapping("/InsertarUsuario")
    public String insertarUsuarioo(@RequestBody Usuario user){
        return servicio.insertaUsuario(user);
    }

    @DeleteMapping("/EliminarUsuario/{Usu_Documento}")
    public String eliminarUsuarioo(@PathVariable("Usu_Documento") String Usu_Documento) {
        return servicio.eliminarUsuario(Usu_Documento);
    }

    @PostMapping("/ActualizarUsuario/")
    public String actualizarUsuarioo(@RequestBody Usuario Doc){
        return servicio.actualizarUsuario(Doc);
    }

}

