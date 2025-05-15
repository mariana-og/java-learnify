package com.example.learnify.modelos;

import com.example.learnify.ayudas.TipoAsistencia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    @Column(name = "fecha", nullable = false)
    private Date Fecha;

    @Column(name = "estado", nullable = false)
    private TipoAsistencia tipoAsistencia;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencia, Date fecha, TipoAsistencia tipoAsistencia) {
        this.idAsistencia = idAsistencia;
        Fecha = fecha;
        this.tipoAsistencia = tipoAsistencia;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public TipoAsistencia getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }
}
