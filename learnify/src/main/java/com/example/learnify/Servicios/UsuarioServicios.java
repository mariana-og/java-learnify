package com.example.learnify.Servicios;

import com.example.learnify.Repositorios.RepositorioUsuario;
import com.example.learnify.ayudas.APIMensajes;
import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicios {
     @Autowired
     RepositorioUsuario repositorio;
     public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
          try {
               return this.repositorio.save(datosUsuario);
          }catch (Exception e){
               throw new Exception();
          }
     }
     public List<Usuario> listaUsuario()throws Exception{
          try {
               return this.repositorio.findAll();
          }catch (Exception e){
               throw new Exception();
          }
     }

     //metodo para buscar por id
     public Usuario buscarUsuario(Integer idUsuario) throws Exception{
          try {
               Optional<Usuario> buscandoUsuario=this.repositorio.findById(idUsuario);
               if(buscandoUsuario.isPresent()){
                    return buscandoUsuario.get();
               } else{
                    throw new Exception(APIMensajes.ERROR_USUARIO_NOT_FOUND.getMensaje());
               }
          } catch (Exception e){
               throw new Exception(e.getMessage());
          }
     }

     //Metodo para modificar
     public boolean modificarUsuario(Integer idUsuario, Usuario nuevosDatos)throws Exception {
          try {
               Optional<Usuario> usuarioEnModificación = this.repositorio.findById(idUsuario);
               if (usuarioEnModificación.isPresent()) {
                    //Modifico el docente
                    usuarioEnModificación.get().setTelefono(nuevosDatos.getTelefono());
                    //Guardo las modificaciones en BD
                    this.repositorio.save(usuarioEnModificación.get());
                    return true;
               } else {
                    throw new Exception(APIMensajes.ERROR_USUARIO_NOT_FOUND.getMensaje());
               }
          } catch (Exception e) {
               throw new Exception(e.getMessage());
          }

     }

          //Metodo para eliminar
          public boolean eliminarUsuario(Integer idUsuario) throws Exception {
               try {
                    Optional<Usuario> buscandoUsuario = this.repositorio.findById(idUsuario);
                    if (buscandoUsuario.isPresent()) {
                         //Lo elimino
                         this.repositorio.deleteById(idUsuario);
                         return true;
                    } else {
                         throw new Exception(APIMensajes.ERROR_USUARIO_NOT_FOUND.getMensaje());
                    }
               } catch (Exception e) {
                    throw new Exception(e.getMessage());
               }
          }
     }

