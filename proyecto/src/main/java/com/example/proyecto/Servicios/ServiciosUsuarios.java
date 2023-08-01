package com.example.proyecto.Servicios;
import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Repositorio.RepositorioUsuarios;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiciosUsuarios {
   private RepositorioUsuarios repositorio;

    public ServiciosUsuarios(RepositorioUsuarios repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> mostrarTodosUsuarios() {
        return repositorio.findAll();
    }

    public ResponseEntity<?> BuscarUsuario(int Usu_Documento) {
        Optional<Usuario> usuarioOptional = repositorio.findById(String.valueOf(Usu_Documento));
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String insertaUsuario(Usuario user){
        if (repositorio.findById(user.getUsu_Documento()).isPresent())
            return "El Usuario ya existe";
        else{
            repositorio.save(user);
            return "Registrado exitosamente";
        }
    }

    public String eliminarUsuario(String Usu_Documento) {
        if (repositorio.findById(Usu_Documento).isPresent()) {
            repositorio.deleteById(Usu_Documento);
            return "El Usuario con numero de Documento " + Usu_Documento + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Usuario con el Numero de Cedula " + Usu_Documento;
        }
    }

    public String actualizarUsuario(Usuario Doc){
        if (repositorio.findById(String.valueOf(Doc.getUsu_Documento())).isPresent()){
            repositorio.save(Doc);
            return "La informacion del Usuario se actualizo correctamente";
        }else{

            return "El usuario no se actualizo, Numero de Cedula no actualizable";
        }
    }
}
