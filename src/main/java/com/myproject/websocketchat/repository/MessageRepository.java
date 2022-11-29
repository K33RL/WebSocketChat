package com.myproject.websocketchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<UserMessage, Long> {
}
