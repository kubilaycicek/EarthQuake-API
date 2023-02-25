package com.kubilaycicek.afadapi.service;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EarthQuakeServiceImpl implements EarthQuakeService {
    final String AFAD_WEB_URL = "https://deprem.afad.gov.tr/last-earthquakes.html";

    @Override
    public List<EarthQuakeDto> getEarthQuakeList() {

        try {

            Document doc = Jsoup.connect(AFAD_WEB_URL).get();
            Elements tableRows = doc.select("tr");

            List<EarthQuakeDto> quakeDtoList = new ArrayList<>();

            if (tableRows.size() != 0) {
                tableRows.remove(0);
            }

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
            log.error("EarthQuake Service : " + exception.getMessage());
        }
        return new ArrayList<>();
    }
}
