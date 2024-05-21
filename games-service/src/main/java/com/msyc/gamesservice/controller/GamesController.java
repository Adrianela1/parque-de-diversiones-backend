package com.msyc.gamesservice.controller;

import com.msyc.gamesservice.dto.GameNameDto;
import com.msyc.gamesservice.model.Games;
import com.msyc.gamesservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/games")
public class GamesController {
    @Autowired
    GamesService gamesService;

    @GetMapping()
    public List<Games> obtenerGames(){
        return gamesService.obtenerGames();
    }

    @PostMapping()
    public Games guardarGames(@RequestBody Games games){
        return this.gamesService.guardarGames(games);
    }

    @GetMapping("/{id}")
    public Optional<Games> obtenerGamesPorId(@PathVariable("id") Long id) {
        return this.gamesService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public List<Games> obtenerGames_namePorAvailable(@RequestParam("available") Boolean available){
        return this.gamesService.obtenerPorAvailable(available);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.gamesService.eliminarGames_name(id);
        if (ok) {
            return "Se eliminó el juego con id " + id;
        }else {
            return "No puedo eliminar el juego con id" + id;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameNameDto>> getAllGameDto() {
        List<GameNameDto> allGames = gamesService.getAllGames();
        return new ResponseEntity<>(allGames, HttpStatus.OK);
    }

}
