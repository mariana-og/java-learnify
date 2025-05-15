package com.example.learnify.controladores;

import com.example.learnify.Servicios.AsistenciaServicio;
import com.example.learnify.Servicios.CalificaciónServicios;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Calificación;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calificación")
public class CalificaciónControlador {

    @Autowired
    CalificaciónServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Calificación datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCalificación(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
