package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioAsistencia;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    RepositorioAsistencia repositorio;

    //metodo para guardar
    public Asistencia guardarAsistencia(Asistencia datosAsistencia) throws Exception{
        try {
            return this.repositorio.save(datosAsistencia);

        }catch (Exception e){
            throw new Exception();
        }
    }

    //metodo para buscarTodos
    public List<Asistencia> listaAsistencia()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }

    //metodo para buscar por id
    public Asistencia buscarAsistenciaById(Integer idAsistencia) throws Exception{
        try {
            Optional<Asistencia> buscandoAsistencia=this.repositorio.findById(idAsistencia);
            if(buscandoAsistencia.isPresent()){
                return buscandoAsistencia.get();
            } else{
                throw new Exception(APIMensajes.ERROR_ASISTENCIA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        }

    //Metodo para modificar
    public boolean modificarAsistencia(Integer idAsistencia, Asistencia nuevosDatos)throws Exception {
        try {
            Optional<Asistencia> asistenciaEnModificación = this.repositorio.findById(idAsistencia);
            if (asistenciaEnModificación.isPresent()) {
                //Modifico el docente
                asistenciaEnModificación.get().setTipoAsistencia(nuevosDatos.getTipoAsistencia());
                //Guardo las modificaciones en BD
                this.repositorio.save(asistenciaEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_ASISTENCIA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

        //Metodo para eliminar
        public boolean eliminarAsistencia (Integer idAsistencia) throws Exception {
            try {
                Optional<Asistencia> buscandoAsistencia = this.repositorio.findById(idAsistencia);
                if (buscandoAsistencia.isPresent()) {
                    //Lo elimino
                    this.repositorio.deleteById(idAsistencia);
                    return true;
                } else {
                    throw new Exception(APIMensajes.ERROR_ASISTENCIA_NOT_FOUND.getMensaje());
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
    }


