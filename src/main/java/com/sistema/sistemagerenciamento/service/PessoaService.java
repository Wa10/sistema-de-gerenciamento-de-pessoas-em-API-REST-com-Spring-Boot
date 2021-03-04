package com.sistema.sistemagerenciamento.service;


import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.entity.Pessoa;
import com.sistema.sistemagerenciamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository personRepository){
        this.pessoaRepository = personRepository;
    }

    public MessageResponseDTO createPessoa(Pessoa pessoa){
        Pessoa savePessoa = pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa Criada com o ID " + savePessoa.getId())
                .build();
    }

}
