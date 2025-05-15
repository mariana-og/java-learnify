package com.example.learnify.Repositorios;

import com.example.learnify.modelos.Asistencia;
import com.example.learnify.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioAsistencia extends JpaRepository<Asistencia, Integer> {
}
