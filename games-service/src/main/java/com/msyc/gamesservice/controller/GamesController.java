package com.msyc.gamesservice.controller;

import com.msyc.gamesservice.model.GamesModel;
import com.msyc.gamesservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping ("/api/games")
public class GamesController {
    @Autowired
    GamesService gamesService;

    @GetMapping()
    public ArrayList<GamesModel> obtenerGames(){
        return gamesService.obtenerGames();
    }

    @PostMapping()
    public GamesModel guardarGames(@RequestBody GamesModel games){
        return this.gamesService.guardarGames(games);
    }

    @GetMapping( path = "/{id}")
    public Optional<GamesModel> obtenerGamesPorId(@PathVariable("id") Long id) {
        return this.gamesService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public ArrayList<GamesModel> obtenerGames_namePorAvailable(@RequestParam("available") Boolean available){
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
}
