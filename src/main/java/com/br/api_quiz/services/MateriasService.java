package com.br.api_quiz.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.exceptions.ObjectNotFoundException;
import com.br.api_quiz.interfaces.MateriasServiceInterface;
import com.br.api_quiz.models.MateriasModel;
import com.br.api_quiz.repositories.MateriasRepository;

@Service
public class MateriasService implements MateriasServiceInterface{

    @Autowired
    public MateriasRepository repository;
    @Autowired
    public ModelMapper mapper;

    @Override
    public List<MateriasModel> findAll() {
        return repository.findAll();
    }

    @Override
    public MateriasModel findId(Integer id) {
        Optional<MateriasModel> materiasOptional = repository.findById(id);
        return materiasOptional.orElseThrow(() -> new ObjectNotFoundException("O objeto não foi encontrado"));
    }


    public List<MateriasModel> findByMateria(MateriasEnum materia) {
        return repository.findByMateria(materia);
    }
    
   

}
