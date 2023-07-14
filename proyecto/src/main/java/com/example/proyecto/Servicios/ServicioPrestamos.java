package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Entidad.Usuario;
import com.example.proyecto.Repositorio.RepositorioPrestamos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPrestamos {
    private RepositorioPrestamos repositorio;

    public ServicioPrestamos(RepositorioPrestamos repositorio){
        this.repositorio= repositorio;
    }

    public List<Prestamo> MostrarTodosPrestamos(){
        return repositorio.findAll();
    }
    public Prestamo Buscarprestamo(int PresId){
        if (repositorio.findById(String.valueOf(PresId)).isPresent())
            return repositorio.findById(String.valueOf(PresId)).get();
            else
                return null;
    }




    public String actualizarPrestamo(Prestamo id){
        if (repositorio.findById(String.valueOf(id.getPresId())).isPresent()){
            repositorio.save(id);
            return "El prestamo se Actualizo exitosamente";
        }else{

            return "El id del prestamo no se modificar: ERROR al actualizar el Prestamo: "+id.getPresId();
        }
    }


    public String insertarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            return "Objeto de prestamo nulo";
        }

        if (repositorio.findById(String.valueOf(prestamo.getPresId())).isPresent()) {
            return "El prestamo ya está registrado";
        } else {
            try {
                repositorio.save(prestamo);
                return "Se registró el prestamo correctamente";
            } catch (Exception e) {
                return "Error al registrar el prestamo: " + e.getMessage();
            }
        }
    }


}
