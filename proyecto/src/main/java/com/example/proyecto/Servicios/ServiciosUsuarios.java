package com.example.proyecto.Servicios;


import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Repositorio.RepositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosUsuarios {
   private RepositorioUsuarios repositorio;

    public ServiciosUsuarios(RepositorioUsuarios repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> mostrarTodosUsuarios() {
        return repositorio.findAll();
    }

    public Usuario BuscarUsuario(int Usu_Documento) {
        if (repositorio.findById(String.valueOf(Usu_Documento)).isPresent())
            return repositorio.findById(String.valueOf(Usu_Documento)).get();
        else
            return null;
    }

    public String insertarUsuario(Usuario usuario) {
        if (usuario == null) {
            return "Objeto de usuario nulo";
        }

        if (repositorio.findById(String.valueOf(usuario.getUsu_Documento())).isPresent()) {
            return "El Usuario ya está registrado";
        } else {
            try {
                repositorio.save(usuario);
                return "Se registró el usuario correctamente";
            } catch (Exception e) {
                return "Error al registrar el usuario: " + e.getMessage();
            }
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
