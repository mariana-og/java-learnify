package com.example.learnify.controladores;

import com.example.learnify.Servicios.AsistenciaServicio;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Asistencia")
public class AsistenciaControlador {
    @Autowired
    AsistenciaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Asistencia datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarAsistencia(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
