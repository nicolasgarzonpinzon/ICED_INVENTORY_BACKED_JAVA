package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.*;
import com.example.proyecto.Repositorio.RepositorioEquipos;
import com.example.proyecto.Repositorio.RepositorioPrestamos;
import com.example.proyecto.Repositorio.RepositorioUsuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
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

    public String actualizarPrestamo(String Eq, String Us, Prestamo prestamo){
        if (reposiEqui.findById(Eq).isPresent() && reposiUsu.findById(Us).isPresent()){
            Equipo eq = reposiEqui.findById(Eq).get();
            Usuario us = reposiUsu.findById(Us).get();
            prestamo.setEquipo(eq);
            prestamo.setUsuario(us);
            repositorio.save(prestamo);
            if (repositorio.findById(String.valueOf(prestamo.getPresId())).isPresent()){
                repositorio.save(prestamo);
                return "Actualizado exitosamente";
            }
            else{

                return "El prestamo no existe";
            }
        }
        else{

            return "Equipo o Usuario  mal ingresado";
        }
    }

    public String insertarPrestamo(String Eq, String Us) {
        // Buscar los registros de equipos y usuarios por sus claves primarias
        Equipo eq = reposiEqui.findById(Eq).orElse(null);
        Usuario us = reposiUsu.findById(Us).orElse(null);

        if (eq != null && us != null) {
            Prestamo p = new Prestamo();
            p.setEquipo(eq);
            p.setUsuario(us);

            // Agregar datos adicionales al objeto Prestamo
            p.setPres_Fec_Entrega(new Date()); // Fecha actual
            p.setPres_Hora_Entrega(new Time(System.currentTimeMillis())); // Hora actual
            p.setPres_Tiempo_Limite(7); // Ejemplo de tiempo límite
            p.setPres_Observaciones_Entrega("Entrega realizada"); // Observaciones

            // Guardar el objeto Prestamo en la base de datos
            repositorio.save(p);

            return "Prestamo Registrado";
        } else {
            return "Cliente, Producto o Usuario mal ingresado";
        }
    }

    public List<Object[]> datosPrestamo(){
        return repositorio.findDatosPrestamo();
    }

    public List<Object[]> usuarioPrestamo(String Us){
        return repositorio.findUsuario(Us);
    }



    public String eliminarPrestamo(int presId) {
        if (repositorio.findById(String.valueOf(presId)).isPresent()) {
            repositorio.deleteById(String.valueOf(presId));
            return "El Dispositivo con el codigo " + presId + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Dispositivo con el codigo " + presId;
        }
    }


}
