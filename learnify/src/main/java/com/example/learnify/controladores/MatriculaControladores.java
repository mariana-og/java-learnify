package com.example.learnify.controladores;

import com.example.learnify.Servicios.EstudianteServicios;
import com.example.learnify.Servicios.MatriculaServicio;
import com.example.learnify.modelos.Estudiante;
import com.example.learnify.modelos.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Matricula")
public class MatriculaControladores {


    @Autowired
    MatriculaServicio servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Matricula datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarMatricula(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
