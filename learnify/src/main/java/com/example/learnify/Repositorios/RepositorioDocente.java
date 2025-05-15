package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDocente extends JpaRepository <Docente,Integer> {
}
