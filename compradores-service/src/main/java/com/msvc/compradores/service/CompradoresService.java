package com.msvc.compradores.service;

import com.msvc.compradores.model.Compradores;
import com.msvc.compradores.repository.CompradoresRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradoresService {

    @Autowired
    private CompradoresRepository compradoresRepository;



    public List<Compradores> getAllCompradores() {
        return compradoresRepository.findAll();
    }

    public Compradores getCompradoresById(Long id) {
        return compradoresRepository.findById(id).orElse(null);
    }

    public List<Compradores> getCompradoresByGameId(String gameId) {
        return compradoresRepository.findByGameId(gameId);
    }

    public Compradores createCompradores(Compradores compradores) {
        return compradoresRepository.save(compradores);
    }

    public Compradores updateCompradores(Long id, Compradores compradoresDetails) {
        Compradores compradores = compradoresRepository.findById(id).orElse(null);
        if (compradores != null) {
            BeanUtils.copyProperties(compradoresDetails, compradores, "id");
            return compradoresRepository.save(compradores);
        }
        return null;
    }

    public void deleteCompradores(Long id) {
        compradoresRepository.deleteById(id);
    }

}
