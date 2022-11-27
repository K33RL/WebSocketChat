package com.myproject.websocketchat.service;

import com.myproject.websocketchat.exception.UserNotFoundException;
import com.myproject.websocketchat.model.User;
import com.myproject.websocketchat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser(Long id) {
        return userRepository.findById(id).
            orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s not found", id)));
    }
}
