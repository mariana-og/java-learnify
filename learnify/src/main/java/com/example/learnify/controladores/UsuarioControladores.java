package com.example.learnify.controladores;

import com.example.learnify.Servicios.EstudianteServicios;
import com.example.learnify.Servicios.UsuarioServicios;
import com.example.learnify.modelos.Estudiante;
import com.example.learnify.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Usuario")
public class UsuarioControladores {


    @Autowired
    UsuarioServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarUsuario(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
