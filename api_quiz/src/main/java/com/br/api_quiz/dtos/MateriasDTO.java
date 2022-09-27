package com.br.api_quiz.dtos;

import javax.validation.constraints.NotBlank;

import com.br.api_quiz.enums.MateriasEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriasDTO {

    private Integer id;
    @NotBlank
    private MateriasEnum materia;
    @NotBlank
    private String pergunta;
    @NotBlank
    private String alternativaCorreta;
    @NotBlank
    private String primeiraAlternativaIncorreta;
    @NotBlank
    private String segundaAlternativaIncorreta;
    @NotBlank
    private String terceiraAlternativaIncorreta;
}
