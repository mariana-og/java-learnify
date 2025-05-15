package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMatricula extends JpaRepository<Matricula, Integer> {
}
