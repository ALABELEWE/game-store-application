package com.alabelewe.game_store_api.model;


import com.alabelewe.game_store_api.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="_User")
public class User extends BaseEntity<String>{
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String profilePictureUrl;
}
