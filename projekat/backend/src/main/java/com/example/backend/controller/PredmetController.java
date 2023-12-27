package com.example.backend.controller;

import lombok.AllArgsConstructor;
import com.example.backend.dto.PredmetDto;
import com.example.backend.service.PredmetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/predmeti")
public class PredmetController {

    private PredmetService predmetService;

    @GetMapping
    public ResponseEntity<List<PredmetDto>> vratiSvePredmete() {
        List<PredmetDto> predmeti = predmetService.vratiSvePredmete();
        return ResponseEntity.ok(predmeti);
    }

    @GetMapping("{id}")
    public ResponseEntity<PredmetDto> getPredmet(@PathVariable("id") Long predmetId) {
        PredmetDto predmetDto = predmetService.getPredmet(predmetId);
        return ResponseEntity.ok(predmetDto);
    }

    @PostMapping
    public ResponseEntity<PredmetDto> kreirajPredmet(@RequestBody PredmetDto predmet) {
        PredmetDto predmetDto = predmetService.kreirajPredmet(predmet);
        return new ResponseEntity<>(predmetDto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<PredmetDto> azurirajPredmet(@PathVariable("id") Long predmetId,
            @RequestBody PredmetDto detaljiPredmeta) {
        PredmetDto azuriranPredmet = predmetService.azurirajPredmet(predmetId, detaljiPredmeta);
        return ResponseEntity.ok(azuriranPredmet);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> obrisiPredmet(@PathVariable("id") Long predmetId) {
        predmetService.obrisiPredmet(predmetId);
        return ResponseEntity.ok("Predmet uspesno obrisan!");
    }
}
