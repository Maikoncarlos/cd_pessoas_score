package com.github.maikoncarlos.cd_pessoas_score.dto;

import lombok.Data;

@Data
public class ByIdPessoaDTO {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;
}