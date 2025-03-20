package com.example.learnify.modelos;

import java.sql.Timestamp;

public class Matricula {
    private Integer idMateria;
    private Timestamp FechaRegistro;

    public Matricula() {
    }

    public Matricula(Integer idMateria, Timestamp fechaRegistro) {
        this.idMateria = idMateria;
        FechaRegistro = fechaRegistro;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Timestamp getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }
}
