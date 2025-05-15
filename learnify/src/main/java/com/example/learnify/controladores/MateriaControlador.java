package com.example.learnify.controladores;


import com.example.learnify.Servicios.EstudianteServicios;
import com.example.learnify.Servicios.MateriaServicios;
import com.example.learnify.modelos.Estudiante;
import com.example.learnify.modelos.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Materia")
public class MateriaControlador {


    @Autowired
    MateriaServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Materia datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarMateria(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
