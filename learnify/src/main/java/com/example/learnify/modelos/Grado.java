package com.example.learnify.modelos;

import java.util.Date;

public class Grado {
    private Integer idGrado;
    private float calificación;
    private Date FechaEvaluación;

    public Grado() {
    }

    public Grado(Integer idGrado, float calificación, Date fechaEvaluación) {
        this.idGrado = idGrado;
        this.calificación = calificación;
        FechaEvaluación = fechaEvaluación;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public float getCalificación() {
        return calificación;
    }

    public void setCalificación(float calificación) {
        this.calificación = calificación;
    }

    public Date getFechaEvaluación() {
        return FechaEvaluación;
    }

    public void setFechaEvaluación(Date fechaEvaluación) {
        FechaEvaluación = fechaEvaluación;
    }
}
