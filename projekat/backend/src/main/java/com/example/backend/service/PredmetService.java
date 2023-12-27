package com.example.backend.service;

import java.util.List;

import com.example.backend.dto.PredmetDto;

public interface PredmetService {
    List<PredmetDto> vratiSvePredmete();

    PredmetDto kreirajPredmet(PredmetDto predmetDto);

    PredmetDto getPredmet(Long predmetId);

    PredmetDto azurirajPredmet(Long predmetId, PredmetDto predmetDto);

    void obrisiPredmet(Long predmetId);
}