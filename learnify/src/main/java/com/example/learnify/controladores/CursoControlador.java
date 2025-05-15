package com.example.learnify.controladores;

import com.example.learnify.Servicios.CursoServicios;
import com.example.learnify.modelos.Curso;
import com.example.learnify.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Curso")
public class CursoControlador {
    @Autowired
    CursoServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Curso datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCurso(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
