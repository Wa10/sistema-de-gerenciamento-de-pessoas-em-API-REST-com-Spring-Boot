package com.sistema.sistemagerenciamento.controller;

import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.entity.Pessoa;
import com.sistema.sistemagerenciamento.repository.PessoaRepository;
import com.sistema.sistemagerenciamento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.createPessoa(pessoa);
    }

}
