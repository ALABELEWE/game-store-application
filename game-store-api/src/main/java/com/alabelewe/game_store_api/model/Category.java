package com.alabelewe.game_store_api.model;

import com.alabelewe.game_store_api.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity<String> {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Game> games;
}
