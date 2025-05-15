package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCurso extends JpaRepository<Curso,Integer> {
}
