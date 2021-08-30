package com.gft.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.exercicio.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
