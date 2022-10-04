package com.br.api_quiz.interfaces;

import java.util.List;

import com.br.api_quiz.dtos.MateriasDTO;
import com.br.api_quiz.models.MateriasModel;

public interface MateriasServiceInterface {
    
    List<MateriasModel> findAll();

    MateriasModel findId(Integer id);

    void deleteById(Integer id);

    MateriasModel create(MateriasDTO materiasDTO);

    MateriasModel update(MateriasDTO materiasDTO);
}
