package com.br.api_quiz.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError {
    
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

}
