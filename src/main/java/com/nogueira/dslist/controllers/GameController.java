package com.nogueira.dslist.controllers;

import com.nogueira.dslist.dto.GameDTO;
import com.nogueira.dslist.dto.GameMinDTO;
import com.nogueira.dslist.entities.Game;
import com.nogueira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@CrossOrigin (allowedHeaders = "*", origins = "*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping ("/{id}")
    public GameDTO findById(@PathVariable Long id){
        return gameService.findById(id);
    }
}
