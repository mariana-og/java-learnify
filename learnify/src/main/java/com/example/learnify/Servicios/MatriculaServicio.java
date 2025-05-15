package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioMatricula;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServicio  {
    @Autowired
    RepositorioMatricula repositorio;
    public Matricula guardarMatricula(Matricula datosMatricula) throws Exception{
        try {
            return this.repositorio.save(datosMatricula);
        }catch (Exception e){
            throw new Exception();
        }
    }

    public List<Matricula> listaMatricula()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }

    public Matricula buscarMatricula(Integer idMatricula) throws Exception{
        try {
            Optional<Matricula> buscandoMatricula=this.repositorio.findById(idMatricula);
            if(buscandoMatricula.isPresent()){
                return buscandoMatricula.get();
            } else{
                throw new Exception(APIMensajes.ERROR_MATRICULA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarMatricula(Integer idMatricula, Matricula nuevosDatos)throws Exception {
        try {
            Optional<Matricula> matriculaEnModificación = this.repositorio.findById(idMatricula);
            if (matriculaEnModificación.isPresent()) {
                //Modifico el docente
                matriculaEnModificación.get().setFechaMatricula(nuevosDatos.getFechaMatricula());
                //Guardo las modificaciones en BD
                this.repositorio.save(matriculaEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_MATRICULA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean eliminarMatricula (Integer idMatricula) throws Exception {
        try {
            Optional<Matricula> buscandoMatricula = this.repositorio.findById(idMatricula);
            if (buscandoMatricula.isPresent()) {
                //Lo elimino
                this.repositorio.deleteById(idMatricula);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_MATRICULA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

