package com.example.proyecto.Controlador;

import com.example.proyecto.Entidad.Prestamo;
import com.example.proyecto.Servicios.ServicioPrestamos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorPrestamos {
    private ServicioPrestamos Servicio;

    public ControladorPrestamos(ServicioPrestamos servicio){
        this.Servicio= servicio;
    }

    @GetMapping("/ListarPrestamos")
    public List<Prestamo> listarPrestamos(){
        return Servicio.MostrarTodosPrestamos();
    }

    @GetMapping("/BuscarPrestamo/{cod}")
    public ResponseEntity<?> buscarID(@PathVariable("cod") int PresId){
        return Servicio.buscarPrestamo(PresId);
    }
    @DeleteMapping("/EliminarPrestamo/{cod}")
    public String eliminarUsuarioo(@PathVariable("cod") int PresId) {
        return Servicio.eliminarPrestamo(PresId);
    }
    @PostMapping("/insertarPrestamo/{Eq}/{Us}")
    public String insertar_Prestamoo(@PathVariable("Eq") String Eq, @PathVariable("Us") String Us) {
        return Servicio.insertarPrestamo(Eq, Us);
    }

    @GetMapping("detallesPrestamo")
    public List<Map<String, Object>> datosPrestamos() {
        List<Object[]> lista = Servicio.datosPrestamo();
        List<Map<String, Object>> json = new ArrayList<>();
        for (Object[] objects : lista) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("presId", objects[0]);
            datos.put("pres_Fec_Entrega", objects[1]);
            datos.put("usu_Nombre", objects[2]);
            datos.put("usu_Apellido", objects[3]);
            datos.put("equi_tipo", objects[4]);
            datos.put("equi_modelo", objects[5]);
            json.add(datos);
        }
        for (Map<String, Object> j : json) {
            System.out.println(j);
        }
        return json;

    }


    @GetMapping("/detallePrestamosEstudiante/{est}")
    public List<Map<String, Object>> Usuarioprestamo(@PathVariable("est") String Us) {
        List<Object[]> lista = Servicio.usuarioPrestamo(Us);
        List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
        for (Object[] objects : lista) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("presId", objects[0]);
            datos.put("pres_Fec_Entrega", objects[1]);
            datos.put("usu_Nombre", objects[2]);
            datos.put("usu_Apellido", objects[3]);
            datos.put("equi_tipo", objects[4]);
            datos.put("equi_modelo", objects[5]);
            json.add(datos);
        }


        for (Map<String, Object> j : json) {
            System.out.println(j);
        }
        return json;
    }

    @PostMapping("/ActualizarPrestamo/{Eq}/{Us}")
    public String actualizarPrestamoo(@PathVariable("Eq") String Eq, @PathVariable("Us") String Us,@RequestBody Prestamo prestamo) {
        return Servicio.actualizarPrestamo(Eq, Us, prestamo);
    }



}
