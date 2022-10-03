package com.br.api_quiz.models;

import javax.persistence.*;

import com.br.api_quiz.enums.MateriasEnum;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_materias")
public class MateriasModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private MateriasEnum materia;
    
    private String pergunta;
    private String alternativaCorreta;
    private String primeiraAlternativaIncorreta;
    private String segundaAlternativaIncorreta;
    private String terceiraAlternativaIncorreta;

}
