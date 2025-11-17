package com.alabelewe.game_store_api.model;


import com.alabelewe.game_store_api.model.common.BaseEntity;
import com.alabelewe.game_store_api.model.enums.NotificationLevel;
import com.alabelewe.game_store_api.model.enums.NotificationStatus;
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
public class Notification extends BaseEntity<String> {
    private String message;
    private String receiver;
    @Enumerated(EnumType.STRING)
    private NotificationLevel level;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
}
