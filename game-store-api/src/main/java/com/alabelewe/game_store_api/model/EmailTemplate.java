package com.alabelewe.game_store_api.model;


import com.alabelewe.game_store_api.model.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailTemplate extends BaseEntity<String> {
    private String template;
}
