package com.github.maikoncarlos.cd_pessoas_score.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;
    @NotBlank
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "idade")
    private int idade;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @NotBlank
    @Column(name = "score")
    private int score;

}