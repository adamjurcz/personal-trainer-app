package com.adamjurcz.personaltrainerapp.presenters.websocket;

import com.adamjurcz.personaltrainerapp.core.domain.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatRoomController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatRoomController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/send.message")
    public void sendPublicMessage(ChatMessage chatMessage){
        simpMessagingTemplate.convertAndSend("/topic/public.messages", chatMessage);
    }
}
