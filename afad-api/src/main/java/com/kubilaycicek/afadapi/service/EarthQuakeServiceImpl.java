package com.kubilaycicek.afadapi.service;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EarthQuakeServiceImpl implements EarthQuakeService {
    static final String AFAD_WEB_URL = "https://deprem.afad.gov.tr/last-earthquakes.html";

    @Cacheable("earthQuakeList")
    @Override
    public List<EarthQuakeDto> getEarthQuakeList() {

        try {
            Connection connection = Jsoup.connect(AFAD_WEB_URL);
            Document document = connection.get();
            Elements tableRows = document.select("tbody > tr");

            List<EarthQuakeDto> quakeDtoList = new ArrayList<>();

            tableRows.stream().forEach(item -> {

                EarthQuakeDto quakeDto = new EarthQuakeDto();
                quakeDto.setDate(item.select("td").get(0).text());
                quakeDto.setLatitude(item.select("td").get(1).text());
                quakeDto.setLongtute(item.select("td").get(2).text());
                quakeDto.setDepth(item.select("td").get(3).text());
                quakeDto.setType(item.select("td").get(4).text());
                quakeDto.setSize(item.select("td").get(5).text());
                quakeDto.setLocation(item.select("td").get(6).text());
                quakeDto.setEarthQuakeId(item.select("td").get(7).text());
                quakeDtoList.add(quakeDto);

            });

            return quakeDtoList;
        } catch (Exception exception) {
            log.error("Message : " + exception.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public List<EarthQuakeDto> getEarthQuakeByCityName(String name) {
        return this.getEarthQuakeList().stream().filter(x -> x.getLocation().toLowerCase().contains(name)).collect(Collectors.toList());
    }

}
