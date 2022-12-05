package com.myproject.websocketchat.service;

import com.myproject.websocketchat.model.UserMessage;
import com.myproject.websocketchat.repository.MessageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<UserMessage> getAllFromUser(Long id) {
        return messageRepository.findAllByUserId(id);
    }
}
