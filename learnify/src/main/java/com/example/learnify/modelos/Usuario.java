package com.example.learnify.modelos;

import com.example.learnify.ayudas.tipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "contraseña", length = 255, nullable = false)
    private String contraseña;

    @Column(name = "correo", unique = true, length = 150, nullable = false)
    private String correo;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @Column(name = "tipo_usuario", nullable = false)
    private tipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String contraseña, String correo, String telefono, tipoUsuario tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public tipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(tipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
