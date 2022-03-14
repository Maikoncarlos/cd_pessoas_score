package com.github.maikoncarlos.cd_pessoas_score.controller;

import com.github.maikoncarlos.cd_pessoas_score.dto.AllPessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.dto.ByIdPessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.dto.PessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/pessoa")
    @ResponseBody
    public ResponseEntity<String> createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.createPessoa(pessoaDTO));

    }

    @GetMapping(value = "/pessoa/{id}")
    public ByIdPessoaDTO findByIdPessoa(@PathVariable @Valid Long id) {
        return pessoaService.findByIdPessoa(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NO_CONTENT, "Pessoa não encontrado"));
    }

    @GetMapping(value = "/pessoa")
    public List<AllPessoaDTO> findAllPessoa() {
        return pessoaService.findAllPessoa();

    }

}