package com.kubilaycicek.afadapi.controller;

import com.kubilaycicek.afadapi.payload.request.BetweenMinAndMaxSizeRequest;
import com.kubilaycicek.afadapi.payload.response.GetEarthQuakeListResponse;
import com.kubilaycicek.afadapi.service.EarthQuakeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/earthquake/")
public class EarthquakeController {

    private final EarthQuakeService earthQuakeService;

    @Operation(
            tags = "EarthQuake Controller",
            summary = "All Records",
            description = "Get All Records"
    )
    @GetMapping("list")
    public ResponseEntity<GetEarthQuakeListResponse> getEarthQuakeList() {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getEarthQuakeList()));
    }

    @Operation(
            tags = "EarthQuake Controller",
            summary = "Get List By City",
            description = "Get List Filter Records By City"
    )
    @GetMapping("list/search/city/name/{name}")
    public ResponseEntity<GetEarthQuakeListResponse> getEarthQuakeByCityName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getListByCityName(name)));
    }

    @Operation(
            tags = "EarthQuake Controller",
            summary = "Filter List Between Min And Max Size",
            description = "Get List Filter Records Betweeb Min And Max Size"
    )
    @GetMapping("list/between-min-and-max-size")
    public ResponseEntity<GetEarthQuakeListResponse> getListFilterBetweenMinAndMaxSize(@RequestBody BetweenMinAndMaxSizeRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(new GetEarthQuakeListResponse(earthQuakeService.getListBetweenMinSizeAndMaxSize(request.getMin(), request.getMax())));
    }

    @Operation(
            tags = "EarthQuake Controller",
            summary = "Clear Cache",
            description = "Clear Cache endpoint"
    )
    @Scheduled(fixedRateString = "${cache.list.earthQuakeListTTL}")
    @CacheEvict("earthQuakeList")
    @PostMapping("clear-memory")
    public ResponseEntity<String> clearAllCacheRecords() {
        log.info("Cleared all cache data");
        return ResponseEntity.status(HttpStatus.OK).body("Cache cleared :)");
    }

}