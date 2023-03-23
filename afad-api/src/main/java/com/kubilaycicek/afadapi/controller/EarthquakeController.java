package com.kubilaycicek.afadapi.controller;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import com.kubilaycicek.afadapi.payload.request.BetweenMinAndMaxSizeRequest;
import com.kubilaycicek.afadapi.payload.response.GetEarthQuakeListResponse;
import com.kubilaycicek.afadapi.service.EarthQuakeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/earthquake/")
public class EarthquakeController {

    private final EarthQuakeService earthQuakeService;

    @GetMapping("list")
    public ResponseEntity<GetEarthQuakeListResponse> getEarthQuakeList() {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getEarthQuakeList()));
    }

    @GetMapping("list/search/city/name/{name}")
    public ResponseEntity<GetEarthQuakeListResponse> getEarthQuakeByCityName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getListByCityName(name)));
    }

    @GetMapping("list/between-min-and-max-size")
    public ResponseEntity<GetEarthQuakeListResponse> getListFilterBetweenMinAndMaxSize(@RequestBody BetweenMinAndMaxSizeRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getListBetweenMinSizeAndMaxSize(request.getMin(), request.getMax())));
    }

    @Scheduled(fixedRateString = "${cache.list.earthQuakeListTTL}")
    @CacheEvict("earthQuakeList")
    @PostMapping("clear-memory")
    public ResponseEntity<String> clearAllCacheRecords() {
        log.info("Cleared all cache data");
        return ResponseEntity.status(HttpStatus.OK).body("Cache cleared :)");
    }

}