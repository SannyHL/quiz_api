package com.br.api_quiz.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.br.api_quiz.dtos.QuestionsDTO;
import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.QuestionsModel;
import com.br.api_quiz.repositories.QuestionsRepository;

public class QuestionsServiceTest {

    private static final int ID = 1;
    private static final String TERCEIRA_ALTERNATIVA_INCORRETA = "60";
    private static final String SEGUNDA_ALTERNATIVA_INCORRETA = "25";
    private static final String PRIMEIRA_ALTERNATIVA_INCORRETA = "55";
    private static final String ALTERNATIVA_CORRETA = "50";
    private static final String PERGUNTA = "Qual o resultado de 5x10?";
    private static final MateriasEnum MATERIA = MateriasEnum.MATEMATICA;

    @InjectMocks
    private QuestionsService service;

    @Mock
    private QuestionsRepository repository;
    @Mock
    private ModelMapper mapper;

    private QuestionsModel questions = new QuestionsModel();
    private Optional<QuestionsModel> questionsOptional;
    private QuestionsDTO questionsDTO = new QuestionsDTO();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startQuestions();
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(repository.save(any())).thenReturn(questions);

        QuestionsModel response = service.create(questionsDTO);
        assertNotNull(response);
        assertEquals(QuestionsModel.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(MATERIA, response.getMateria());
        assertEquals(PERGUNTA, response.getPergunta());
        assertEquals(ALTERNATIVA_CORRETA, response.getAlternativaCorreta());
        assertEquals(PRIMEIRA_ALTERNATIVA_INCORRETA, response.getPrimeiraAlternativaIncorreta());
        assertEquals(SEGUNDA_ALTERNATIVA_INCORRETA, response.getSegundaAlternativaIncorreta());
        assertEquals(TERCEIRA_ALTERNATIVA_INCORRETA, response.getTerceiraAlternativaIncorreta());
    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindByMateria() {

    }

    @Test
    void testFindId() {

    }

    @Test
    void testUpdate() {

    }

    private void startQuestions(){

        questions  = new QuestionsModel(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

        questionsDTO  = new QuestionsDTO(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

        questionsOptional  = Optional.of(new QuestionsModel(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA));
    }
}
