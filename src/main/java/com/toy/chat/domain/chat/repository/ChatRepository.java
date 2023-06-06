package com.toy.chat.domain.chat.repository;

import com.toy.chat.domain.chat.model.Chat;
import com.toy.chat.domain.chat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatRepositoryCustom {
}
