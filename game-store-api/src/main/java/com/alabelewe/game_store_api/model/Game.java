package com.alabelewe.game_store_api.model;


import com.alabelewe.game_store_api.model.common.BaseEntity;
import com.alabelewe.game_store_api.model.enums.SupportPlatforms;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game extends BaseEntity<String> {
    private String title;
    @Enumerated(EnumType.STRING)
    private SupportPlatforms platform;
    private String coverPicture;
    private String description;

}
