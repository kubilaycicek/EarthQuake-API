package com.kubilaycicek.afadapi.payload.response;

import com.kubilaycicek.afadapi.payload.dto.EarthQuakeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEarthQuakeListResponse {
    List <EarthQuakeDto> earthQuakeList;
}
