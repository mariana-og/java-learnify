package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {
}
