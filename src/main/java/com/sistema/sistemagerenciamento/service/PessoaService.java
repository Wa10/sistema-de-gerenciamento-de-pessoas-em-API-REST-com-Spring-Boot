package com.sistema.sistemagerenciamento.service;


import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.dto.request.PessoaDTO;
import com.sistema.sistemagerenciamento.entity.Pessoa;
import com.sistema.sistemagerenciamento.mapper.PessoaMapper;
import com.sistema.sistemagerenciamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository personRepository){
        this.pessoaRepository = personRepository;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){

        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);
        Pessoa savePessoa = pessoaRepository.save(pessoaParaSalvar);
        return MessageResponseDTO
                .builder()
                .message("Pessoa Criada com o ID " + savePessoa.getId())
                .build();
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
