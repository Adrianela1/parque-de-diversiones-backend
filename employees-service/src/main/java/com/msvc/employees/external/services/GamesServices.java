package com.msvc.employees.external.services;

import com.msvc.employees.model.Games;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "GAMES-SERVICE")
public interface GamesServices {

    @GetMapping("/api/games/all")
    List<Games> getEmployeesAndGameName();
}
