package com.br.api_quiz.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.br.api_quiz.dtos.QuestionsDTO;
import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.QuestionsModel;
import com.br.api_quiz.services.QuestionsService;

public class QuestionsControllerTest {

    private static final int ID = 1;
    private static final String TERCEIRA_ALTERNATIVA_INCORRETA = "60";
    private static final String SEGUNDA_ALTERNATIVA_INCORRETA = "25";
    private static final String PRIMEIRA_ALTERNATIVA_INCORRETA = "55";
    private static final String ALTERNATIVA_CORRETA = "50";
    private static final String PERGUNTA = "Qual o resultado de 5x10?";
    private static final MateriasEnum MATERIA = MateriasEnum.MATEMATICA;

    @InjectMocks
    private QuestionsController controller;

    @Mock
    private QuestionsService service;
    @Mock
    private ModelMapper mapper;

    private QuestionsModel questions = new QuestionsModel();
    private QuestionsDTO questionsDTO = new QuestionsDTO();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startQuestions();
    }

    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByMateria() {

    }

    @Test
    void testUpdate() {

    }

    private void startQuestions(){

        questions  = new QuestionsModel(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

        questionsDTO  = new QuestionsDTO(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

    }
}
