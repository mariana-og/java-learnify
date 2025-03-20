package com.example.learnify.modelos;

import java.util.Date;

public class Estudiante {
    private Integer  idEstudiante;
    private Integer calificación;
    private Date FechaNacimiento;
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, Integer calificación, Date fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.calificación = calificación;
        FechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getCalificación() {
        return calificación;
    }

    public void setCalificación(Integer calificación) {
        this.calificación = calificación;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
