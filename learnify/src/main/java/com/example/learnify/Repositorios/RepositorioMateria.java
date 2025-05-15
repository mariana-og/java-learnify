package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMateria extends JpaRepository <Materia,Integer> {
}
