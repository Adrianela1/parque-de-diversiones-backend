package com.msvc.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {

    private Long id;
    private String gameName;
    private String operatingHours;
    private Boolean available;

}
