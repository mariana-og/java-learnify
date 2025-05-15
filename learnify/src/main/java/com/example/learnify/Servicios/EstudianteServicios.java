package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioEstudiante;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Docente;
import com.example.learnify.modelos.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicios {

    @Autowired
    RepositorioEstudiante repositorio;
    public Estudiante guardarEstudiante(Estudiante datosEstudiantes) throws Exception{
        try {
            return this.repositorio.save(datosEstudiantes);

        }catch (Exception e){
            throw new Exception();
        }
    }

    public List<Estudiante> listaEstudiantes()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }
    public Estudiante buscarEstudiantePorId(Integer idEstudiante) throws Exception{
        try {
            Optional<Estudiante> buscandoEstudiante=this.repositorio.findById(idEstudiante);
            if(buscandoEstudiante.isPresent()){
                return buscandoEstudiante.get();
            } else{
                throw new Exception(APIMensajes.ERROR_ESTUDIANTE_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarEstudiante(Integer idEstudiante, Estudiante nuevosDatos)throws Exception {
        try {
            Optional<Estudiante> EstudianteEnModificación = this.repositorio.findById(idEstudiante);
            if (EstudianteEnModificación.isPresent()) {
                //Modifico el docente
                EstudianteEnModificación.get().setDireccion(nuevosDatos.getDireccion());
                //Guardo las modificaciones en BD
                this.repositorio.save(EstudianteEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_ESTUDIANTE_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean eliminarEstudiante(Integer idEstudiante) throws Exception{
        try{
            Optional<Estudiante> buscandoEstudiante=this.repositorio.findById(idEstudiante);
            if(buscandoEstudiante.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(idEstudiante);
                return true;
            } else{
                throw new Exception(APIMensajes.ERROR_ESTUDIANTE_NOT_FOUND.getMensaje());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


    }
