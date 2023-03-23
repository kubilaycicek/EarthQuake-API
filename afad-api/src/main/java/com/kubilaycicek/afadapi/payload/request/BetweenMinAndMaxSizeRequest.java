package com.kubilaycicek.afadapi.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenMinAndMaxSizeRequest {
    private Double min;
    private Double max;
}
