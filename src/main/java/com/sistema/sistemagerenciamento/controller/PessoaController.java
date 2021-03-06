package com.sistema.sistemagerenciamento.controller;

import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.dto.request.PessoaDTO;
import com.sistema.sistemagerenciamento.exception.PessoaNotFoundException;
import com.sistema.sistemagerenciamento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listAll(){
        return pessoaService.listAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable Long id) throws PessoaNotFoundException {
        return pessoaService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        return pessoaService.updateById(id, pessoaDTO);
    }
}
