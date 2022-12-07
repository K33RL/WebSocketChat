package com.myproject.websocketchat.controller;

import com.myproject.websocketchat.model.UserMessage;
import com.myproject.websocketchat.service.MessageService;
import com.myproject.websocketchat.storage.UserStorage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final MessageService messageService;

    @MessageMapping("/chat{to}")
    public void sendMessage(@DestinationVariable String to, UserMessage message) {
        System.out.println("handling send message" + message + "to:" + to);
        boolean isExists = UserStorage.getInstance().getUser().contains(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages" + to, message);
        }
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<List<UserMessage>> getAllUserMessages(@PathVariable Long id) {
        List<UserMessage> allFromUser = messageService.getAllFromUser(id);
        return new ResponseEntity<>(allFromUser, HttpStatus.OK);
    }
}
