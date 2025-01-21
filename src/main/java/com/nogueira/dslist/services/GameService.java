package com.nogueira.dslist.services;

import com.nogueira.dslist.dto.GameMinDTO;
import com.nogueira.dslist.entities.Game;
import com.nogueira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> gamelist = gameRepository.findAll();
        List<GameMinDTO> dto = gamelist.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
