package com.br.api_quiz.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api_quiz.dtos.QuestionsDTO;
import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.exceptions.ObjectNotFoundException;
import com.br.api_quiz.interfaces.QuestionsServiceInterface;
import com.br.api_quiz.models.QuestionsModel;
import com.br.api_quiz.repositories.QuestionsRepository;

@Service
public class QuestionsService implements QuestionsServiceInterface{

    @Autowired
    public QuestionsRepository repository;
    @Autowired
    public ModelMapper mapper;

    @Override
    public List<QuestionsModel> findAll() {
        return repository.findAll();
    }

    @Override
    public QuestionsModel findId(Integer id) {
        Optional<QuestionsModel> materiasOptional = repository.findById(id);
        return materiasOptional.orElseThrow(() -> new ObjectNotFoundException("O objeto não foi encontrado"));
    }

    public List<QuestionsModel> findByMateria(MateriasEnum materia) {
        return repository.findByMateria(materia);
    }

    @Override
    public void deleteById(Integer id) {
        findId(id);
        repository.deleteById(id);;
        
    }

    @Override
    public QuestionsModel create(QuestionsDTO questionsDTO) {
        return repository.save(mapper.map(questionsDTO, QuestionsModel.class));
    }

    @Override
    public QuestionsModel update(QuestionsDTO questionsDTO) {
        return repository.save(mapper.map(questionsDTO, QuestionsModel.class));
    }
    
}
