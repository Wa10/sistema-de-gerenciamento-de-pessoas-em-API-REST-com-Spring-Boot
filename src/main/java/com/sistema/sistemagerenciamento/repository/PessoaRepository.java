package com.sistema.sistemagerenciamento.repository;

import com.sistema.sistemagerenciamento.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
