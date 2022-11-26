package com.myproject.websocketchat.controller;

import com.myproject.websocketchat.storage.UserStorage;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/registration/{username}")
    public ResponseEntity<Void> registration(@PathVariable String username) {
        System.out.println(username);
        try {
            UserStorage.getInstance().setUser(username);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return UserStorage.getInstance().getUser();
    }
}
