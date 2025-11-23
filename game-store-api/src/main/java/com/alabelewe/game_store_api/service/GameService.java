package com.alabelewe.game_store_api.service;


import com.alabelewe.game_store_api.model.Category;
import com.alabelewe.game_store_api.model.Game;
import com.alabelewe.game_store_api.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public void something(String categoryId){

        var game =  gameRepository.findById(categoryId);

    }

    public void doSomethingElse(){
        List<Game> games = gameRepository.findAll();

        for(Game game : games){
            game.setTitle(game.getTitle());
        }
        gameRepository.saveAll(games);
    }



}
