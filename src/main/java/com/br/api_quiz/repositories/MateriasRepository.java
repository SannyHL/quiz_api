package com.br.api_quiz.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.MateriasModel;

public interface MateriasRepository extends JpaRepository<MateriasModel, Integer>{
    
    List<MateriasModel> findByMateria(MateriasEnum materia);
}
