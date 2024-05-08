package com.msyc.gamesservice.service;

import com.msyc.gamesservice.model.GamesModel;
import com.msyc.gamesservice.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GamesService {
    @Autowired
    GamesRepository gamesRepository;

    public ArrayList<GamesModel> obtenerGames(){
        return (ArrayList<GamesModel>)gamesRepository.findAll();
    }
    public GamesModel guardarGames(GamesModel games){
        return gamesRepository.save(games);
    }

    public Optional<GamesModel> obtenerPorId(Long id){
        return gamesRepository.findById(id);
    }

    public ArrayList<GamesModel> obtenerPorAvailable(Boolean available){
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
