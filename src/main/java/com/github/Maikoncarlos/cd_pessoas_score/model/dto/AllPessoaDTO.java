package com.github.maikoncarlos.cd_pessoas_score.model.dto;

import lombok.Data;

@Data
public class AllPessoaDTO {

    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;
}