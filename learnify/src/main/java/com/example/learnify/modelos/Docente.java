package com.example.learnify.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer idDocente;

    @Column(name = "especialidad", length = 100, unique = false, nullable = false)
    private String especialidad;

    //creando la relacion (uno a muchos)
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;

    public Docente() {
    }

    public Docente(Integer idDocente, String especialidad) {
        this.idDocente = idDocente;
        this.especialidad = especialidad;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
