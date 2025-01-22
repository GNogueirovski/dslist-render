package com.nogueira.dslist.repositories;

import com.nogueira.dslist.entities.Game;
import com.nogueira.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
