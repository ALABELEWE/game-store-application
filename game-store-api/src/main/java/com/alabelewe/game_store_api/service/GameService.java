package com.alabelewe.game_store_api.service;


import com.alabelewe.game_store_api.dto.PageResponse;
import com.alabelewe.game_store_api.model.Category;
import com.alabelewe.game_store_api.model.Game;
import com.alabelewe.game_store_api.model.enums.SupportPlatforms;
import com.alabelewe.game_store_api.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public PageResponse<Game> pageResult(final int page, final int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<Game> games = gameRepository.findAllByCategoryName("catName",pageable);


        return PageResponse.<Game>builder()
                .content(games.getContent())
                .totalPages(games.getTotalPages())
                .totalElements(games.getNumberOfElements())
                .isFirst(games.isFirst())
                .isLast(games.isLast())
                .build();
    }
    public void queryByExampleCaseSensitive(){
        Game game = new Game();
        game.setTitle("The commando");
        game.setPlatform(SupportPlatforms.ANDROID);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("platform", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<Game> example = Example.of(game, matcher);

        Optional<Game> myGame =  gameRepository.findOne(example);
    }



}
