package com.adamjurcz.personaltrainerapp.dataproviders.entity.chatmessages;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table("chat_message")
public class ChatMessageData {
    @PrimaryKeyColumn(name="username", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String username;

    @PrimaryKeyColumn(name="chat_room_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String chatRoomId;

    @PrimaryKeyColumn(name="date", ordinal = 2, type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.ASCENDING)
    private Date timestamp;

    private String fromUser;
    private String toUser;
    private String text;
}
