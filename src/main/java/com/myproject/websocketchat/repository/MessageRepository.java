package com.myproject.websocketchat.repository;

import com.myproject.websocketchat.model.UserMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<UserMessage, Long> {
    @Query("SELECT um from UserMessage um where um.userId = :id")
    List<UserMessage> findAllByUserId(Long id);
}
