package com.br.api_quiz.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.api_quiz.dtos.QuestionsDTO;
import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.QuestionsModel;
import com.br.api_quiz.services.QuestionsService;


@SpringBootTest
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

    private QuestionsModel questions;
    private QuestionsDTO questionsDTO;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startQuestions();
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(questions);

        ResponseEntity<QuestionsDTO> response = controller.create(questionsDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response);
        assertNull(response.getBody());
        assertNotNull(response.getHeaders().get("Location"));
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    void whenDeleteThenReturnSuccess() {
        doNothing().when(service).deleteById(anyInt());

        ResponseEntity<QuestionsDTO> response = controller.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        verify(service, times(1)).deleteById(anyInt());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void whenFindAllThenReturnAnListUserDto() {
        when(service.findAll()).thenReturn(List.of(questions));
        when(mapper.map(any(), any())).thenReturn(questionsDTO);

        ResponseEntity<List<QuestionsDTO>> response = controller.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(QuestionsDTO.class, response.getBody().get(0).getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(MATERIA, response.getBody().get(0).getMateria());
        assertEquals(ALTERNATIVA_CORRETA, response.getBody().get(0).getAlternativaCorreta());
        assertEquals(PRIMEIRA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getPrimeiraAlternativaIncorreta());
        assertEquals(SEGUNDA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getSegundaAlternativaIncorreta());
        assertEquals(TERCEIRA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getTerceiraAlternativaIncorreta());


    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findId(anyInt())).thenReturn(questions);

        when(mapper.map(any(), any())).thenReturn(questionsDTO);

        ResponseEntity<QuestionsDTO> response = controller.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(QuestionsDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(MATERIA, response.getBody().getMateria());
        assertEquals(ALTERNATIVA_CORRETA, response.getBody().getAlternativaCorreta());
        assertEquals(PRIMEIRA_ALTERNATIVA_INCORRETA, response.getBody().getPrimeiraAlternativaIncorreta());
        assertEquals(SEGUNDA_ALTERNATIVA_INCORRETA, response.getBody().getSegundaAlternativaIncorreta());
        assertEquals(TERCEIRA_ALTERNATIVA_INCORRETA, response.getBody().getTerceiraAlternativaIncorreta());



    }

    @Test
    void whenFindByMateriaThenReturnSuccess() {
        when(service.findByMateria(any())).thenReturn(List.of(questions));
        when(mapper.map(any(), any())).thenReturn(questionsDTO);

        ResponseEntity<List<QuestionsDTO>> response = controller.findByMateria(MATERIA);

        
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(QuestionsDTO.class, response.getBody().get(0).getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(MATERIA, response.getBody().get(0).getMateria());
        assertEquals(ALTERNATIVA_CORRETA, response.getBody().get(0).getAlternativaCorreta());
        assertEquals(PRIMEIRA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getPrimeiraAlternativaIncorreta());
        assertEquals(SEGUNDA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getSegundaAlternativaIncorreta());
        assertEquals(TERCEIRA_ALTERNATIVA_INCORRETA, response.getBody().get(0).getTerceiraAlternativaIncorreta());
        
        



    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(questionsDTO)).thenReturn(questions);
        when(mapper.map(any(), any())).thenReturn(questionsDTO);
        ResponseEntity<QuestionsDTO> response = controller.update(ID, questionsDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(QuestionsDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(MATERIA, response.getBody().getMateria());
        assertEquals(ALTERNATIVA_CORRETA, response.getBody().getAlternativaCorreta());
        assertEquals(PRIMEIRA_ALTERNATIVA_INCORRETA, response.getBody().getPrimeiraAlternativaIncorreta());
        assertEquals(SEGUNDA_ALTERNATIVA_INCORRETA, response.getBody().getSegundaAlternativaIncorreta());
        assertEquals(TERCEIRA_ALTERNATIVA_INCORRETA, response.getBody().getTerceiraAlternativaIncorreta());
    }

    private void startQuestions(){

        questions  = new QuestionsModel(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

        questionsDTO  = new QuestionsDTO(ID, MATERIA, PERGUNTA, ALTERNATIVA_CORRETA, PRIMEIRA_ALTERNATIVA_INCORRETA, SEGUNDA_ALTERNATIVA_INCORRETA, TERCEIRA_ALTERNATIVA_INCORRETA);

    }
}
