package com.br.api_quiz.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.api_quiz.dtos.MateriasDTO;
import com.br.api_quiz.enums.MateriasEnum;
import com.br.api_quiz.models.MateriasModel;
import com.br.api_quiz.services.MateriasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/questions")
@Api(tags = "Materias Controller")
public class MateriasController {

    /**
     *
     */
    private static final String ID = "{id}";
    @Autowired
    public MateriasService service;
    @Autowired
    public ModelMapper mapper;

    @GetMapping
    @ApiOperation("Find all questions")
    public ResponseEntity<List<MateriasDTO>> findAll(){
        return ResponseEntity.ok()
        .body(service.findAll()
        .stream().map(objetos -> mapper.map(objetos, MateriasDTO.class))
        .collect(Collectors.toList()));
    }

    @GetMapping(ID)
    @ApiOperation("Find question by id")
    public ResponseEntity<MateriasDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findId(id), MateriasDTO.class)); 
    }

    @GetMapping("findByMateria")
    @ApiOperation("Find by materia")
    public ResponseEntity<List<MateriasDTO>> findByMateria(@RequestParam(value = "materia") MateriasEnum materia){
        return ResponseEntity.ok()
        .body(service.findByMateria(materia)
        .stream().map(objetos -> mapper.map(objetos, MateriasDTO.class))
        .collect(Collectors.toList()));
    } 

    @PostMapping
    @ApiOperation("Create question")
    public ResponseEntity<MateriasDTO> create(@RequestBody MateriasDTO materiasDTO){
        MateriasModel materias = service.create(materiasDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(materias.getId()).toUri();
        return ResponseEntity.created(uri).build();
        
    }

    @PutMapping(ID)
    @ApiOperation("Update question")
    public ResponseEntity<MateriasDTO> update(@PathVariable Integer id, @RequestBody MateriasDTO materiasDTO){
        materiasDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service
        .update(materiasDTO), MateriasDTO.class));
    }

    @DeleteMapping(ID)
    @ApiOperation("Delete question")
    public ResponseEntity<MateriasDTO> delete(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
  
}
