package com.msvc.sales.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value= "sales")
@Builder
@Data
@NoArgsConstructor

public class SalesModel {
    @Id
    private Long id;
    private Long idBuyer;
    private Long idGame;
    private String date;
}
