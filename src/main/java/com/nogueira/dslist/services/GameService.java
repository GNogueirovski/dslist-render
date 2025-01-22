package com.nogueira.dslist.services;

import com.nogueira.dslist.dto.GameDTO;
import com.nogueira.dslist.dto.GameMinDTO;
import com.nogueira.dslist.entities.Game;
import com.nogueira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
       return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> gamelist = gameRepository.findAll();
        List<GameMinDTO> dto = gamelist.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    
}
