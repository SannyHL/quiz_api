package com.br.api_quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api_quiz.models.MateriasModel;

public interface MateriasRepository extends JpaRepository<MateriasModel, Integer>{
    
}
