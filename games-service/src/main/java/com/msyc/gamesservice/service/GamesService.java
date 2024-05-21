package com.msyc.gamesservice.service;

import com.msyc.gamesservice.dto.GameNameDto;
import com.msyc.gamesservice.model.Games;
import com.msyc.gamesservice.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GamesService {
    @Autowired
    GamesRepository gamesRepository;

    public List<Games> obtenerGames(){
        return gamesRepository.findAll();
    }

    public List<GameNameDto> getAllGames() {
        List<Games> gamesList = gamesRepository.findAll();
        return gamesList.stream()
                .map(games -> GameNameDto.builder()
                        .gameName(games.getGameName())
                        .id(games.getId())
                        .build())
                .collect(Collectors.toList());
    }

    public Games guardarGames(Games games){
        return gamesRepository.save(games);
    }

    public Optional<Games> obtenerPorId(Long id){
        return gamesRepository.findById(id);
    }

    public List<Games> obtenerPorAvailable(Boolean available){
        return gamesRepository.findByAvailable(available);
    }

    public boolean eliminarGames_name(Long id) {
        try {
            gamesRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }

    }
}
