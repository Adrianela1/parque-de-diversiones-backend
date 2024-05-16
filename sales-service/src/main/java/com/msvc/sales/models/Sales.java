package com.msvc.sales.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value= "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    @Id
    private String salesId;
    private String buyerId;
    private String date;

    @Transient
    private List<Compradores> compradores = new ArrayList<>();
}
