package com.example.learnify.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer  idEstudiante;

    @Column(name = "grado", nullable = false)
    private Integer grado;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date FechaNacimiento;

    @Column(name = "dirección", length = 255, nullable = false)
    private String direccion;


    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia>asistencias;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificación>calificaciónes;



    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, Integer grado, Date fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.grado = grado;
        FechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
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
