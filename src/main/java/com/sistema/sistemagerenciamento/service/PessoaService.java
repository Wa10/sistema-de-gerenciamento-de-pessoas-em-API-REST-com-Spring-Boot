package com.sistema.sistemagerenciamento.service;


import com.sistema.sistemagerenciamento.dto.MessageResponseDTO;
import com.sistema.sistemagerenciamento.dto.request.PessoaDTO;
import com.sistema.sistemagerenciamento.entity.Pessoa;
import com.sistema.sistemagerenciamento.exception.PessoaNotFoundException;
import com.sistema.sistemagerenciamento.mapper.PessoaMapper;
import com.sistema.sistemagerenciamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
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
        return criarMessageResponse(savePessoa.getId(), "Pessoa criada com o ID ");
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDTO(pessoa);
    }

    public void delete(Long id) throws PessoaNotFoundException {
        verificaSeExiste(id);
        pessoaRepository.deleteById(id);
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    public MessageResponseDTO updateById(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verificaSeExiste(id);

        Pessoa updatePessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savePessoa = pessoaRepository.save(updatePessoa);
        return criarMessageResponse(savePessoa.getId(), "Pessoa atualizada com o ID ");
    }

    private MessageResponseDTO criarMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
