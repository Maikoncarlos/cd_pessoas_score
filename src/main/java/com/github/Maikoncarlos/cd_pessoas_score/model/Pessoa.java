package com.github.maikoncarlos.cd_pessoas_score.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "telefone")
    private String telefone;
    @NotNull
    @Column(name = "idade")
    private int idade;
    @NotNull
    @Column(name = "cidade")
    private String cidade;
    @NotNull
    @Column(name = "estado")
    private String estado;
    @NotNull
    @Column(name = "score")
    private int score;

}