package com.alabelewe.game_store_api.repository;


import com.alabelewe.game_store_api.model.Category;
import com.alabelewe.game_store_api.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {

    List<Game> findAllByCategory(Category category);

    List<Game> findAllByCategoryId(String categoryId);

    List<Game> findAllByCategoryName(String categoryName);

//
//    @Query("""
//        SELECT g FROM Game g
//            INNER JOIN Category c ON g.category.id = c.id
//                WHERE c.name LIKE :categoryName
//        """)
@Query("""
        SELECT g FROM Game g
            INNER JOIN g.category c
                WHERE c.name LIKE :categoryName
        """)
    List<Game> findAllByCat(String categoryName);


    @Query("""
            UPDATE Game SET title = upper(title) 
            """
    )
    @Modifying
    void tranformGameToUpperCase();


}
