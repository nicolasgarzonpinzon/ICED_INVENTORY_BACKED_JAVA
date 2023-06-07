package com.example.proyecto.Servicios;

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
    public Prestamo BuscarSancion(int San_Pres_Id){
        if (repositorio.findById(String.valueOf(San_Pres_Id)).isPresent())
            return repositorio.findById(String.valueOf(San_Pres_Id)).get();
            else
                return null;
    }

    public String eliminarPrestamo(String San_Pres_Id) {
        if (repositorio.findById(San_Pres_Id).isPresent()) {
            repositorio.deleteById(San_Pres_Id);
            return "El Prestamo con el codigo " + San_Pres_Id + " fue eliminado exitosamente";
        } else {
            return "No se encontró Ningun Prestamo con el codigo " + San_Pres_Id;
        }
    }

    public String actualizarPrestamo(Prestamo id){
        if (repositorio.findById(String.valueOf(id.getPres_Id())).isPresent()){
            repositorio.save(id);
            return "El prestamo se Actualizo exitosamente";
        }else{

            return "El id del prestamo no se modificar: ERROR al actualizar el Prestamo: "+id.getPres_Id();
        }
    }
}
