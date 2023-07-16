package com.example.proyecto.Servicios;

import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Entidad.Sancion;
import com.example.proyecto.Repositorio.RepositorioSanciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioSanciones {
    private RepositorioSanciones repositorio;

    public ServicioSanciones(RepositorioSanciones repositorio){
        this.repositorio=repositorio;
    }
    public List<Sancion>MostrarTodosSanciones(){
        return repositorio.findAll();
    }


    public Sancion BuscarSanciones(int san_pres_id) {
        if (repositorio.findById(String.valueOf(san_pres_id)).isPresent())
            return repositorio.findById(String.valueOf(san_pres_id)).get();
        else
            return null;
    }

    public String insertarSanciones(Sancion sancion) {
        if (sancion == null) {
            return "Objeto de Sancion nulo";
        }

        if (repositorio.findById(String.valueOf(sancion.getPres_Id())).isPresent()) {
            return "Sancion ya registrada";
        } else {
            try {
                repositorio.save(sancion);
                return "Se registró la Sancion correctamente";
            } catch (Exception e) {
                return "Error al registrar la Sancion: " + e.getMessage();
            }
        }
    }

    public String eliminarSanciones(String id) {
        if (repositorio.findById(id).isPresent()) {
            repositorio.deleteById(id);
            return "El Dispositivo con el codigo " + id + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Dispositivo con el codigo " + id;
        }
    }

    public String actualizarSanciones(Sancion E){
        if (repositorio.findById(String.valueOf(E.getSan_Pres_Id())).isPresent()){
            repositorio.save(E);
            return "Sancion actualiazada correctamente";
        }else{

            return "la sancion no se actualizo, id ya existente";
        }
    }

    }


