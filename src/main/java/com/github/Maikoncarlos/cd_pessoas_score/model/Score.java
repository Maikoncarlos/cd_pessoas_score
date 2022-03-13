package com.github.maikoncarlos.cd_pessoas_score.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_score")
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "scoreDescricao")
    private String scoreDescricao;
    @Column(name = "scoreInicial")
    private int scoreInicial;
    @Column(name = "scoreFinal")
    private int scoreFinal;

}
