package com.adamjurcz.personaltrainerapp.core.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatMessage {
    private String username;

    private String chatRoomId;

    private Date date;

    private String fromUser;
    private String toUser;
    private String text;
}
