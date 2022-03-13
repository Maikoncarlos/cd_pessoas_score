package com.github.maikoncarlos.cd_pessoas_score.repository;

import com.github.maikoncarlos.cd_pessoas_score.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}