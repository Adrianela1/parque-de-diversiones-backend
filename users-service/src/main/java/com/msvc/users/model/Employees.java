package com.msvc.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employees {

    private Long id;
    private String name;
    private String assignedGame;
    private String userId;

}
