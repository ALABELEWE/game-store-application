package com.alabelewe.game_store_api.repository;

import com.alabelewe.game_store_api.model.Category;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllByNameStartingWithIgnoreCaseOrderByNameAsc(String name);



    @Query("""
            SELECT c FROM Category c
                WHERE c.name LIKE lower(:name)
                    ORDER BY c.name ASC
    """)
    List<Category> findAllByName(String name);

    @Query(value = "SELECT * FROM category WHERE name LIKE :catName ORDER BY name ASC", nativeQuery = true)
    List<Category> findAllByNameUsingNativeQuery(@Param("catName") String categoryName);
}
