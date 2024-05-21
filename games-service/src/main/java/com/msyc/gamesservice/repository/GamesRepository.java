package com.msyc.gamesservice.repository;

import com.msyc.gamesservice.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    public abstract List<Games> findByAvailable(Boolean available);
}
