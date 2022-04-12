package com.github.maikoncarlos.cd_pessoas_score.model.dto;

import lombok.Data;

@Data
public class PessoaDTO {

    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    private String estado;
    private int score;

}