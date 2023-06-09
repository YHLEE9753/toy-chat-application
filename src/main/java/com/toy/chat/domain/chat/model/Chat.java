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
public class Chat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "chat_body")
    private String chatBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Chat(String chatBody, ChatRoom chatRoom) {
        this.chatBody = chatBody;
        this.chatRoom = chatRoom;
        this.isDeleted = false;
    }
}
