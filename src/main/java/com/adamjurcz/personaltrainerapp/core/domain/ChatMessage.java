package com.adamjurcz.personaltrainerapp.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatMessage {
    private Identity id;

    private String message;

    private String toJID;

    private Integer messageLength;

    private Status status;


}
