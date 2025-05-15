package com.example.learnify.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Integer idMateria;


    @CreationTimestamp
    @Column(name = "fecha_matricula", updatable = false)
    private Timestamp FechaMatricula;

    public Matricula() {
    }

    public Matricula(Integer idMateria, Timestamp fechaMatricula) {
        this.idMateria = idMateria;
        FechaMatricula = fechaMatricula;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Timestamp getFechaMatricula() {
        return FechaMatricula;
    }

    public void setFechaMatricula(Timestamp fechaMatricula) {
        FechaMatricula = fechaMatricula;
    }
}
