package com.nogueira.dslist.controllers;

import com.nogueira.dslist.dto.GameListDTO;
import com.nogueira.dslist.dto.GameMinDTO;
import com.nogueira.dslist.dto.ReplacementDTO;
import com.nogueira.dslist.services.GameListService;
import com.nogueira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
    return gameListService.findAll();
    }

    @GetMapping(value = "/{listid}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listid){
        return gameService.findByList(listid);
    }

    @PostMapping(value = "/{listid}/replacement")
    public void move(@PathVariable Long listid, @RequestBody ReplacementDTO body){
        gameListService.move(listid, body.getSourceIndex(), body.getDestinationIndex());
    }

}
