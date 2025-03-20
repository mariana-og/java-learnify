package com.example.learnify.modelos;

import com.example.learnify.ayudas.TipoAsistencia;

import java.util.Date;

public class Asistencia {
    private Integer idAsistencia;
    private Date Fecha;
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
