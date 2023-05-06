package com.adamjurcz.personaltrainerapp.dataproviders.entity.chatrooms;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@RedisHash("chat_room")
public class ChatRoomData {
    @Id
    private String id;

    private String name;

    private String description;

}
