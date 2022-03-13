package com.github.maikoncarlos.cd_pessoas_score.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelmapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

//        modelMapper.createTypeMap(Pessoa.class, AllPessoaDTO.class)
//                .addMapping((origem -> origem.getScore(), (dest, value) -> dest.setScore(value)))
//    }



