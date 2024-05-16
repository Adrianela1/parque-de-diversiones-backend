package com.msvc.compradores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buyeers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Compradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gameId;
}
