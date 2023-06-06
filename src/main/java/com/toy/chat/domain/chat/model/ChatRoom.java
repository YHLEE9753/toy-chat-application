package com.toy.chat.domain.chat.model;

import com.toy.chat.global.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "chatroom_name")
    private String chatroomName;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public ChatRoom(String chatroomName) {
        this.chatroomName = chatroomName;
        this.isDeleted = false;
    }
}
