package com.sistema.sistemagerenciamento.service;


import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.dto.request.PessoaDTO;
import com.sistema.sistemagerenciamento.entity.Pessoa;
import com.sistema.sistemagerenciamento.mapper.PessoaMapper;
import com.sistema.sistemagerenciamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    private final PessoaMapper personMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository personRepository){
        this.pessoaRepository = personRepository;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){

        Pessoa pessoaParaSalvar = personMapper.toModel(pessoaDTO);
        Pessoa savePessoa = pessoaRepository.save(pessoaParaSalvar);
        return MessageResponseDTO
                .builder()
                .message("Pessoa Criada com o ID " + savePessoa.getId())
                .build();
    }

}
