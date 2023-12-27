package com.example.backend;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.backend.dto.PredmetDto;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.PredmetMapper;
import com.example.backend.model.Predmet;
import com.example.backend.repository.PredmetRepository;
import com.example.backend.service.PredmetService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PredmetServiceImpl implements PredmetService {

    private PredmetRepository predmetRepository;

    @Override
    public List<PredmetDto> vratiSvePredmete() {
        List<Predmet> predmeti = predmetRepository.findAll();
        List<PredmetDto> predmetiDto = predmeti.stream()
                .map((predmet) -> PredmetMapper.mapirajUPredmetDto(predmet))
                .collect(Collectors.toList());
        return predmetiDto;
    }

    @Override
    public PredmetDto kreirajPredmet(PredmetDto predmetDto) {
        Predmet predmet = PredmetMapper.mapirajUPredmet(predmetDto);
        Predmet sacuvanPredmet = predmetRepository.save(predmet);
        return PredmetMapper.mapirajUPredmetDto(sacuvanPredmet);
    }

    @Override
    public PredmetDto getPredmet(Long predmetId) {
        Predmet predmet = predmetRepository.findById(predmetId)
                .orElseThrow(() -> new ResourceNotFoundException("Ne postoji predmet sa id-om: " + predmetId));
        PredmetDto predmetDto = PredmetMapper.mapirajUPredmetDto(predmet);
        return predmetDto;
    }

    @Override
    public PredmetDto azurirajPredmet(Long predmetId, PredmetDto predmetDto) {

        Predmet postojeciPredmet = predmetRepository.findById(predmetId)
                .orElseThrow(() -> new ResourceNotFoundException("Ne postoji predmet sa id-om: " + predmetId));

        postojeciPredmet.setImePredmeta(predmetDto.getImePredmeta());

        predmetRepository.save(postojeciPredmet);
        return PredmetMapper.mapirajUPredmetDto(postojeciPredmet);
    }

    @Override
    public void obrisiPredmet(Long predmetId) {

        predmetRepository.findById(predmetId)
                .orElseThrow(() -> new ResourceNotFoundException("Ne postoji predmet sa id-om: " + predmetId));

        predmetRepository.deleteById(predmetId);
    }
}
