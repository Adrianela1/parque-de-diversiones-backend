package com.msvc.tickets.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CantidadEntradasVendidasJuegoDto {

    private Long id;
    private String date;
    private String gameName;

}
