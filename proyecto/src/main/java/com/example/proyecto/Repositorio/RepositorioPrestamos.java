package com.example.proyecto.Repositorio;

import com.example.proyecto.Entidad.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioPrestamos extends JpaRepository<Prestamo,String>{

    @Query(value="select p.presId, p.pres_Fec_Entrega, u.usu_Nombre, u.usu_Apellido, e.equi_tipo, e.equi_modelo from prestamo as p inner join usuario as u on p.usu_Documento = u.usu_Documento inner join equipo as e on p.equ_id = e.equ_id", nativeQuery = true)
    List<Object[]> findDatosPrestamo();

    @Query(value="select p.presId, p.pres_Fec_Entrega, u.usu_Nombre, u.usu_Apellido, e.equi_tipo, e.equi_modelo from prestamo as p inner join usuario as e on p.usu_Documento = u.usu_Documento inner join equipo as e on p.equ_id = e.equ_id where p.usu_Documento= :Us", nativeQuery = true)
    List<Object[]> findUsuario(String Us);
}
