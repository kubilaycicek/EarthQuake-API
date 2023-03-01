package com.kubilaycicek.afadapi.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthQuakeDto {
    private String date;
    private String latitude;
    private String longtute;
    private String depth;
    private String type;
    private String size;
    private String location;
    private String earthQuakeId;

}