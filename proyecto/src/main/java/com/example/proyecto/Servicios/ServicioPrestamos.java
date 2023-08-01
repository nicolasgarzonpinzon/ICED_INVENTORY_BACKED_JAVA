package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.*;
import com.example.proyecto.Repositorio.RepositorioEquipos;
import com.example.proyecto.Repositorio.RepositorioPrestamos;
import com.example.proyecto.Repositorio.RepositorioUsuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPrestamos {
    private RepositorioPrestamos repositorio;
    private RepositorioEquipos reposiEqui;
    private RepositorioUsuarios reposiUsu;

    public ServicioPrestamos(RepositorioPrestamos repositorio, RepositorioEquipos reposiEqui, RepositorioUsuarios reposiUsu) {
        this.repositorio = repositorio;
        this.reposiEqui = reposiEqui;
        this.reposiUsu = reposiUsu;
    }

    public List<Prestamo> MostrarTodosPrestamos(){
        return repositorio.findAll();
    }

    public ResponseEntity<?> buscarPrestamo(int presId) {
        Optional<Prestamo> prestamoOptional = repositorio.findById(String.valueOf(presId));
        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            return ResponseEntity.ok(prestamo);
        } else {
            String mensaje = "El préstamo con ID " + presId + " no existe.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }





    public String actualizarPrestamo(Prestamo id){
        if (repositorio.findById(String.valueOf(id.getPresId())).isPresent()){
            repositorio.save(id);
            return "El prestamo se Actualizo exitosamente";
        }else{

            return "El id del prestamo no se modificar: ERROR al actualizar el Prestamo: "+id.getPresId();
        }
    }

    public String insertarPrestamo(String Eq, String Us, Prestamo prestamo) {
        if (reposiEqui.findById(Eq).isPresent() && reposiUsu.findById(Us).isPresent()){
            Equipo eq = reposiEqui.findBy(Eq).get();
            Usuario us = reposiUsu.findBy(Us).get();

            prestamo.setEqu_id_equipos(eq);
            prestamo.setUsu_Documento_usurios(us);
            repositorio.save(prestamo);
            return "Registro Exitoso";
        }
        else {
            return "Cliente, Producto o Usuario mal ingresado";
        }

    }


    public String eliminarPrestamo(String id) {
        if (repositorio.findById(id).isPresent()) {
            repositorio.deleteById(id);
            return "El Dispositivo con el codigo " + id + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Dispositivo con el codigo " + id;
        }
    }


}
