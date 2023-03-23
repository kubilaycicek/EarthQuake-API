package com.kubilaycicek.afadapi.service;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;

import java.util.List;

public interface EarthQuakeService {
    List<EarthQuakeDto> getEarthQuakeList();
    List<EarthQuakeDto> getListByCityName(String name);

    List<EarthQuakeDto> getListBetweenMinSizeAndMaxSize(Double min,Double max);
}
