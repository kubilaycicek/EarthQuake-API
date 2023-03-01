package com.kubilaycicek.afadapi.controller;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import com.kubilaycicek.afadapi.service.EarthQuakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/earthquake/")
public class EarthquakeController {

    private final EarthQuakeService earthQuakeService;

    @GetMapping("list")
    public ResponseEntity<List<EarthQuakeDto>> getEarthQuakeList() {

        return ResponseEntity.status(HttpStatus.OK).body(earthQuakeService.getEarthQuakeList());
    }
    @GetMapping("list/search/city/name/{name}")
    public ResponseEntity<List<EarthQuakeDto>> getEarthQuakeByCityName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(earthQuakeService.getEarthQuakeByCityName(name));
    }

}
