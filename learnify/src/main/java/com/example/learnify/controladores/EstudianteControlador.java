package com.example.learnify.controladores;

import com.example.learnify.Servicios.CalificaciónServicios;
import com.example.learnify.Servicios.EstudianteServicios;
import com.example.learnify.modelos.Calificación;
import com.example.learnify.modelos.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Estudiante")
public class EstudianteControlador {

    @Autowired
    EstudianteServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Estudiante datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarEstudiante(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
