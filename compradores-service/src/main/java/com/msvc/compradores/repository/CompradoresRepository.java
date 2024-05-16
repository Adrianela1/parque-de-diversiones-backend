package com.msvc.compradores.repository;

import com.msvc.compradores.model.Compradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompradoresRepository extends JpaRepository<Compradores, Long> {

    List<Compradores> findByGameId(String gameId);

}
