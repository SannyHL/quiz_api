package com.br.api_quiz.interfaces;

import java.util.List;

import com.br.api_quiz.models.MateriasModel;

public interface MateriasServiceInterface {
    

    public List<MateriasModel> findAll();

    public MateriasModel findId(Integer id);
}
