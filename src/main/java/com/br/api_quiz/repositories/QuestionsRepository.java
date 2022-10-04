package com.br.api_quiz.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.QuestionsModel;

public interface QuestionsRepository extends JpaRepository<QuestionsModel, Integer>{
    
    List<QuestionsModel> findByMateria(MateriasEnum materia);
}
