package com.example.proyecto.Servicios;
import com.example.proyecto.Entidad.Equipo;
import com.example.proyecto.Repositorio.RepositorioEquipos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicioEquipos {
    private RepositorioEquipos reposiEqui;

    public ServicioEquipos(RepositorioEquipos repositorio) {
        this.reposiEqui = repositorio;
    }

    public List<Equipo> mostrarTodos() {
        return reposiEqui.findAll();
    }

    public ResponseEntity<?> buscarEquipo(int equId) {
        Optional<Equipo> equipoOptional = reposiEqui.findById(String.valueOf(equId));
        if (equipoOptional.isPresent()) {
            Equipo equipo = equipoOptional.get();
            return ResponseEntity.ok(equipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String insertaEquipo(Equipo Eq){
        if (reposiEqui.findById(Eq.getEqu_id()).isPresent())
            return "El equipo ya existe";
        else{
            reposiEqui.save(Eq);
            return "Registrado exitosamente";
        }
    }



    public String eliminarEquipo(String codigo) {
        if (reposiEqui.findById(codigo).isPresent()) {
            reposiEqui.deleteById(codigo);
            return "El Dispositivo con el codigo " + codigo + " fue eliminado exitosamente";
        } else {
            return "No se encontró ningún Dispositivo con el codigo " + codigo;
        }
    }

    public String actualizarEquipo(Equipo E){
        if (reposiEqui.findById(String.valueOf(E.getEqu_id())).isPresent()){
            reposiEqui.save(E);
            return "El equipo se Actualizo correctamente";
        }else{

            return "El id del equipo ya existe";
        }
    }
}

