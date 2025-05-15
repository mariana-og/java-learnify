package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioMateria;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicios {
    @Autowired
    RepositorioMateria repositorio;
    public Materia guardarMateria(Materia datosMateria) throws Exception{
        try {
            return this.repositorio.save(datosMateria);
        }catch (Exception e){
            throw new Exception();
        }
    }
    public List<Materia> listaMateria()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception();
        }
    }

    public Materia buscarMateria(Integer idMateria) throws Exception{
        try {
            Optional<Materia> buscandoMateria=this.repositorio.findById(idMateria);
            if(buscandoMateria.isPresent()){
                return buscandoMateria.get();
            } else{
                throw new Exception(APIMensajes.ERROR_MATERIA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean modificarMateria(Integer idMateria, Materia nuevosDatos)throws Exception {
        try {
            Optional<Materia> MateriaEnModificación = this.repositorio.findById(idMateria);
            if (MateriaEnModificación.isPresent()) {
                //Modifico el docente
                MateriaEnModificación.get().setNombre(nuevosDatos.getNombre());
                //Guardo las modificaciones en BD
                this.repositorio.save(MateriaEnModificación.get());
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_MATERIA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean eliminarMateria (Integer idMateria) throws Exception {
        try {
            Optional<Materia> buscandoMateria = this.repositorio.findById(idMateria);
            if (buscandoMateria.isPresent()) {
                //Lo elimino
                this.repositorio.deleteById(idMateria);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_MATERIA_NOT_FOUND.getMensaje());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

