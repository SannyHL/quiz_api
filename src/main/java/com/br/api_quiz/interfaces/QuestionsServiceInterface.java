package com.br.api_quiz.interfaces;

import java.util.List;

import com.br.api_quiz.dtos.QuestionsDTO;
import com.br.api_quiz.models.QuestionsModel;

public interface QuestionsServiceInterface {
    
    List<QuestionsModel> findAll();

    QuestionsModel findId(Integer id);

    void deleteById(Integer id);

    QuestionsModel create(QuestionsDTO questionsDTO);

    QuestionsModel update(QuestionsDTO questionsDTO);
}
