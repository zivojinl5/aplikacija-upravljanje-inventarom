package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {
}