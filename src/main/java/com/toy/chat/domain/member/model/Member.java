package com.toy.chat.domain.member.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "email", length = 40, unique = true, nullable = false)
    private String email;

    @Column(name = "nick_name", length = 30, unique = true, nullable = false)
    private String nickName;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Member(String email, String nickName) {
        this.email = new Email(email).getAddress();;
        this.nickName = nickName;
        this.isDeleted = false;
    }
}
