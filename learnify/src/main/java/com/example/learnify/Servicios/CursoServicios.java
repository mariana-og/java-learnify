package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioCurso;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicios {
    @Autowired
    RepositorioCurso repositorio;
    public Curso guardarCurso(Curso datosCurso) throws Exception{
        try {
            return this.repositorio.save(datosCurso);

        }catch (Exception e){
            throw new Exception();
        }
    }
    public List<Curso> listaCurso()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }
    public Curso buscarCurso(Integer idCurso) throws Exception{
        try {
            Optional<Curso> buscandoCurso=this.repositorio.findById(idCurso);
            if(buscandoCurso.isPresent()){
                return buscandoCurso.get();
            } else{
                throw new Exception(APIMensajes.ERROR_CURSO_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarCurso(Integer idCurso, Curso nuevosDatos)throws Exception {
        try {
            Optional<Curso> CursoEnModificación = this.repositorio.findById(idCurso);
            if (CursoEnModificación.isPresent()) {
                //Modifico el docente
                CursoEnModificación.get().setNombre(nuevosDatos.getNombre());
                //Guardo las modificaciones en BD
                this.repositorio.save(CursoEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CURSO_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean eliminarCurso (Integer idCurso) throws Exception {
        try {
            Optional<Curso> buscandoCurso = this.repositorio.findById(idCurso);
            if (buscandoCurso.isPresent()) {
                //Lo elimino
                this.repositorio.deleteById(idCurso);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CURSO_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

