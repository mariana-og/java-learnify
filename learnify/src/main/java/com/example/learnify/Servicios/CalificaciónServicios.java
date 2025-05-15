package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioCalificación;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Calificación;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificaciónServicios {
    @Autowired
    RepositorioCalificación repositorio;
    public Calificación guardarCalificación(Calificación datosCalificación) throws Exception{
        try {
            return this.repositorio.save(datosCalificación);
        }catch (Exception e){
            throw new Exception();
        }
    }
    public List<Calificación> listaCalificación()throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public Calificación buscarCalificación(Integer idCalificación) throws Exception{
        try {
            Optional<Calificación> buscandoCalificación=this.repositorio.findById(idCalificación);
            if(buscandoCalificación.isPresent()){
                return buscandoCalificación.get();
            } else{
                throw new Exception(APIMensajes.ERROR_CALIFICACIÓN_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarCalificación(Integer idCalificación, Calificación nuevosDatos)throws Exception {
        try {
            Optional<Calificación> CalificaciónEnModificación = this.repositorio.findById(idCalificación);
            if (CalificaciónEnModificación.isPresent()) {
                //Modifico el docente
                CalificaciónEnModificación.get().setFechaEvaluación(nuevosDatos.getFechaEvaluación());
                //Guardo las modificaciones en BD
                this.repositorio.save(CalificaciónEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CALIFICACIÓN_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean eliminarCalificación(Integer idCalificación) throws Exception{
        try{
            Optional<Calificación> buscandoCalificación=this.repositorio.findById(idCalificación);
            if(buscandoCalificación.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(idCalificación);
                return true;
            } else{
                throw new Exception(APIMensajes.ERROR_CALIFICACIÓN_NOT_FOUND.getMensaje());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
