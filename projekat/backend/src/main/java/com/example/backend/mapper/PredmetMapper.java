package com.example.backend.mapper;

import com.example.backend.dto.PredmetDto;
import com.example.backend.model.Predmet;

public class PredmetMapper {

    public static PredmetDto mapirajUPredmetDto(Predmet predmet) {
        PredmetDto predmetDto = new PredmetDto();
        predmetDto.setId(predmet.getId());
        predmetDto.setImePredmeta(predmet.getImePredmeta());

        return predmetDto;
    }

    public static Predmet mapirajUPredmet(PredmetDto predmetDto) {
        Predmet predmet = new Predmet();
        predmet.setImePredmeta(predmetDto.getImePredmeta());

        return predmet;
    }

}