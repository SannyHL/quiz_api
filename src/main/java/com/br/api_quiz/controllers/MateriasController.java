package com.br.api_quiz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api_quiz.dtos.MateriasDTO;
import com.br.api_quiz.services.MateriasService;

@RestController
@RequestMapping
public class MateriasController {

    @Autowired
    public MateriasService service;
    @Autowired
    public ModelMapper mapper;

    @GetMapping("/")
    public ResponseEntity<List<MateriasDTO>> findAll(){
        return ResponseEntity.ok()
        .body(service.findAll()
        .stream().map(objetos -> mapper.map(objetos, MateriasDTO.class))
        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriasDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findId(id), MateriasDTO.class)); 
    }
       
}
