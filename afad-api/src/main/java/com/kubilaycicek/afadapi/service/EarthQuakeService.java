package com.kubilaycicek.afadapi.service;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;

import java.util.List;

public interface EarthQuakeService {
    List<EarthQuakeDto> getEarthQuakeList();
    List<EarthQuakeDto> getEarthQuakeByCityName(String name);
}
