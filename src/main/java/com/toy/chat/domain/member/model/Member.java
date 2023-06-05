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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }

    public String changeName(String name){
        this.name = name;
        return name;
    }
}
