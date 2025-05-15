package com.example.learnify.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "calificaciónes")

public class Calificación {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificación")
    private Integer idGrado;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id_materia")
    @JsonBackReference
    private Materia materia;

    @Column(name = "nota", columnDefinition = "DECIMAL(5,2)", nullable = false)
    private float calificación;

    @Column(name = "fecha_evaluación", nullable = false)
    private Date FechaEvaluación;

    public Calificación() {
    }

    public Calificación(Integer idGrado, float calificación, Date fechaEvaluación) {
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
