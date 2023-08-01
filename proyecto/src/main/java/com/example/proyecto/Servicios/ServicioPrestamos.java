package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Repositorio.RepositorioPrestamos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPrestamos {
    private RepositorioPrestamos repositorio;

    public ServicioPrestamos(RepositorioPrestamos repositorio){
        this.repositorio= repositorio;
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



    public String eliminarPrestamo(String id) {
        if (repositorio.findById(id).isPresent()) {
            repositorio.deleteById(id);
            return "El Dispositivo con el codigo " + id + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Dispositivo con el codigo " + id;
        }
    }


}
