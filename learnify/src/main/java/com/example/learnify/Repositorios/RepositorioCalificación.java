package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Calificación;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCalificación extends JpaRepository<Calificación, Integer> {
}
