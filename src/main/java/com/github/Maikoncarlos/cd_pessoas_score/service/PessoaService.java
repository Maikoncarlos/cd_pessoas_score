package com.github.maikoncarlos.cd_pessoas_score.service;

import com.github.maikoncarlos.cd_pessoas_score.model.dto.AllPessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.model.dto.ByIdPessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.model.dto.PessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.model.Pessoa;
import com.github.maikoncarlos.cd_pessoas_score.model.Score;
import com.github.maikoncarlos.cd_pessoas_score.repository.PessoaRepository;
import com.github.maikoncarlos.cd_pessoas_score.repository.ScoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ModelMapper modelMapper;


    public String createPessoa(PessoaDTO pessoaDTO) {
        return this.createPessoa(pessoaDTO, modelMapper);
    }

    protected String createPessoa(PessoaDTO pessoaDTO, ModelMapper modelMapper) {
        try {
            Pessoa pessoa = pessoaRepository.save(pessoaDTOtoPessoa(pessoaDTO, modelMapper));
            return pessoa.getId() > 0 ? "salvo com sucesso" : "";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public Optional<ByIdPessoaDTO> findByIdPessoa(Long id) {
        return validByIdPessoa(pessoaRepository.findById(id));
    }


    public List<AllPessoaDTO> findAllPessoa() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        List<AllPessoaDTO> allPessoaDTOList = new ArrayList<>();
        AllPessoaDTO allPessoaDTO;

        for (Pessoa p : pessoaList) {
            allPessoaDTO = toAllPessoaDTO(p);
            allPessoaDTO.setScoreDescricao(carregarScore(p.getScore()));
            allPessoaDTOList.add(allPessoaDTO);
        }
        if(!pessoaList.isEmpty()){
            return allPessoaDTOList;
        }else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

    private Pessoa pessoaDTOtoPessoa(PessoaDTO pessoaDTO, ModelMapper modelMapper) {
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }

    protected AllPessoaDTO toAllPessoaDTO(Pessoa pessoa) {
        return this.toAllPessoaDTO(pessoa, modelMapper);
    }

    protected AllPessoaDTO toAllPessoaDTO(Pessoa pessoa, ModelMapper modelMapper) {

        var allPessoaDTO = new AllPessoaDTO();
        allPessoaDTO.setNome(pessoa.getNome());
        allPessoaDTO.setCidade(pessoa.getCidade());
        allPessoaDTO.setEstado(pessoa.getEstado());
        allPessoaDTO.setScoreDescricao(carregarScore(pessoa.getScore()));
        return modelMapper.map(pessoa, AllPessoaDTO.class);
    }

    private String carregarScore(int score) {
        List<Score> scoreList = scoreRepository.findAll(); 
        for (Score s : scoreList) {
            if (getDescriptionScore(s.getScoreInicial(), s.getScoreFinal(), score)) {
                return s.getScoreDescricao();
            }
        }

        return "";
    }

    private Boolean getDescriptionScore(int initScore, int endScore, int pessoaScore) {
        return pessoaScore >= initScore && pessoaScore <= endScore;
    }

    private Optional<ByIdPessoaDTO> validByIdPessoa(Optional<Pessoa> pessoa) {
        List<Score> score = scoreRepository.findAll();
        Optional<ByIdPessoaDTO> byIdPessoaDTO = toByOptionalPessoaDTO(pessoa);
        for (Score s : score) {
            if (pessoa.get().getScore() >= s.getScoreInicial() && pessoa.get().getScore() <= s.getScoreFinal()) {
                byIdPessoaDTO.get().setScoreDescricao(s.getScoreDescricao());
                break;
            }
        }
        return byIdPessoaDTO;
    }

    private Optional<ByIdPessoaDTO> toByOptionalPessoaDTO(Optional<Pessoa> pessoa) {
        if (pessoa.isPresent()) {
            Optional<ByIdPessoaDTO> by = Optional.of(new ByIdPessoaDTO());
            by.get().setNome(pessoa.get().getNome());
            by.get().setTelefone(pessoa.get().getTelefone());
            by.get().setIdade(pessoa.get().getIdade());
            return by;
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}