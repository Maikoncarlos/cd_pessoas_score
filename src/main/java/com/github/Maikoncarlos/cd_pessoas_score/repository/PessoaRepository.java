package com.github.maikoncarlos.cd_pessoas_score.repository;

import com.github.maikoncarlos.cd_pessoas_score.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}