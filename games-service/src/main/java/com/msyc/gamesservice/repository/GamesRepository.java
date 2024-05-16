package com.msyc.gamesservice.repository;

import com.msyc.gamesservice.model.GamesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GamesRepository extends CrudRepository<GamesModel, Long> {
    public abstract ArrayList<GamesModel>findByAvailable(Boolean available);
}
