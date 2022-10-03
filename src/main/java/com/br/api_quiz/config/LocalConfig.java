package com.br.api_quiz.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.MateriasModel;
import com.br.api_quiz.repositories.MateriasRepository;


@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private MateriasRepository repository;

    @Bean
    public void startDataBase(){
        var questao1 = new MateriasModel(null, MateriasEnum.MATEMATICA, "Qual o resultado de 5x10?", "50", "55", "25", "60");

        var questao2 = new MateriasModel(null, MateriasEnum.MATEMATICA, "Qual o resultado de 6x10?", "60", "75", "25", "50");

        var questao3 = new MateriasModel(null, MateriasEnum.GEOGRAFIA, "Qual é a capital do Brasil?", "Brasília", "Rio de Janeiro", "Bahia", "Minas Gerais");

        repository.saveAll(List.of(questao1, questao2, questao3));
    }
    
}
