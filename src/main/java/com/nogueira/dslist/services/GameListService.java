package com.nogueira.dslist.services;

import com.nogueira.dslist.dto.GameDTO;
import com.nogueira.dslist.dto.GameListDTO;
import com.nogueira.dslist.entities.Game;
import com.nogueira.dslist.entities.GameList;
import com.nogueira.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    
}
