package com.example.proyecto.Repositorio;

import com.example.proyecto.Entidad.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios  extends JpaRepository<Usuarios,String> {
}
