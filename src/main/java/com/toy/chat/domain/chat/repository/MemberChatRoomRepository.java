package com.toy.chat.domain.chat.repository;

import com.toy.chat.domain.chat.model.MemberChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberChatRoomRepository extends JpaRepository<MemberChatRoom, Long>, MemberChatRoomRepositoryCustom {
}
