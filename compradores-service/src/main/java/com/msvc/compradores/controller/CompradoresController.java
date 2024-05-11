package com.msvc.compradores.controller;

import com.msvc.compradores.model.Compradores;
import com.msvc.compradores.service.CompradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compradores")
public class CompradoresController {

    @Autowired
    private CompradoresService compradoresService;


    @GetMapping
    public ResponseEntity<List<Compradores>> getAllUsers() {
        List<Compradores> compradores = compradoresService.getAllCompradores();
        return new ResponseEntity<>(compradores, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Compradores> getUserById(@PathVariable Long id) {
        Compradores compradores = compradoresService.getCompradoresById(id);
        if (compradores != null) {
            return new ResponseEntity<>(compradores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<List<Compradores>> getUserByGameId(@PathVariable String gameId) {
        return ResponseEntity.ok(compradoresService.getCompradoresByGameId(gameId));
    }

    @PostMapping
    public ResponseEntity<Compradores> createUser(@RequestBody Compradores compradores) {
        Compradores createdCompradores = compradoresService.createCompradores(compradores);
        return new ResponseEntity<>(createdCompradores, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compradores> updateUser(@PathVariable Long id, @RequestBody Compradores compradoresDetails) {
        Compradores updatedCompradores = compradoresService.updateCompradores(id, compradoresDetails);
        if (updatedCompradores != null) {
            return new ResponseEntity<>(updatedCompradores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        compradoresService.deleteCompradores(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
