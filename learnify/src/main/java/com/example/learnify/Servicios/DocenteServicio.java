package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioDocente;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired
    RepositorioDocente repositorio;
    public Docente guardarDocente(Docente datosDocente) throws Exception{
        try {
            return this.repositorio.save(datosDocente);
        }catch (Exception e){
            throw new Exception();
        }
    }

    public List<Docente> listaDocentes()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }
    public Docente buscarDocente(Integer idDocente) throws Exception{
        try {
            Optional<Docente> buscandoDocente=this.repositorio.findById(idDocente);
            if(buscandoDocente.isPresent()){
                return buscandoDocente.get();
            } else{
                throw new Exception(APIMensajes.ERROR_DOCENTE_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarDocente(Integer idDocente, Docente nuevosDatos)throws Exception {
        try {
            Optional<Docente> DocenteEnModificación = this.repositorio.findById(idDocente);
            if (DocenteEnModificación.isPresent()) {
                //Modifico el docente
                DocenteEnModificación.get().setEspecialidad(nuevosDatos.getEspecialidad());
                //Guardo las modificaciones en BD
                this.repositorio.save(DocenteEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_DOCENTE_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean eliminarDocente (Integer idDocente) throws Exception {
        try {
            Optional<Docente> buscandoDocente = this.repositorio.findById(idDocente);
            if (buscandoDocente.isPresent()) {
                //Lo elimino
                this.repositorio.deleteById(idDocente);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_DOCENTE_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

