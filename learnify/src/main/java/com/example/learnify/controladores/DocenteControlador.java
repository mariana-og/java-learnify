package com.example.learnify.controladores;

import com.example.learnify.Servicios.DocenteServicio;
import com.example.learnify.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docentes")
public class DocenteControlador {
    @Autowired
    DocenteServicio servicio;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Docente datosQueEnviaElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarDocente(datosQueEnviaElCliente));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    //buscartodos

    //buscarporId
}

