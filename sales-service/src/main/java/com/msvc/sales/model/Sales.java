package com.msvc.sales.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "sales")
@Builder
@Data
@NoArgsConstructor

public class Sales {
    @Id
    private Long id;
    private String idBuyer;
    private String idGame;
    private String date;
}
