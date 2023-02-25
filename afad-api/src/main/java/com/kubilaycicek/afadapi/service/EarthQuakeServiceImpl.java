package com.kubilaycicek.afadapi.service;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EarthQuakeServiceImpl implements EarthQuakeService {
    final String AFAD_WEB_URL = "https://deprem.afad.gov.tr/last-earthquakes.html";

    @Override
    public List<EarthQuakeDto> getEarthQuakeList() {
        try {
            Document doc = Jsoup.connect(AFAD_WEB_URL).get();
            Elements tableRows = doc.select("tr");
            List<EarthQuakeDto> quakeDtoList = new ArrayList<>();
            for (Element row : tableRows.next()) {
                EarthQuakeDto quakeDto = new EarthQuakeDto();
                quakeDto.setDate(row.select("td").get(0).text());
                quakeDto.setLatitude(row.select("td").get(1).text());
                quakeDto.setLongtute(row.select("td").get(2).text());
                quakeDto.setDepth(row.select("td").get(3).text());
                quakeDto.setType(row.select("td").get(4).text());
                quakeDto.setSize(row.select("td").get(5).text());
                quakeDto.setLocation(row.select("td").get(6).text());
                quakeDto.setEarthQuakeId(row.select("td").get(7).text());
                quakeDtoList.add(quakeDto);
            }

            return quakeDtoList;
        } catch (Exception exception) {
            System.out.println("Sorry");
        }
        return new ArrayList<>();
    }
}
