package com.example.learnify.ayudas;

public enum APIMensajes {
    ERROR_DOCENTE_NOT_FOUND("El docente que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_ESTUDIANTE_NOT_FOUND("El estudiante que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_ASISTENCIA_NOT_FOUND("El asistencia que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_CURSO_NOT_FOUND("El curso que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_USUARIO_NOT_FOUND("El usuario que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_CALIFICACIÓN_NOT_FOUND("La calificación que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_MATERIA_NOT_FOUND("La materia que estás intentando encontrar no se encuentra en la base de datos"),
    ERROR_MATRICULA_NOT_FOUND("La matricula que estás intentando encontrar no se encuentra en la base de datos"),;



    private String mensaje;

    APIMensajes(String mensaje) {
        this.mensaje=mensaje;
    }

    public String getMensaje(){
        return mensaje;
    }
}
