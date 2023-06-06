package com.toy.chat.domain.member.dto;

import lombok.Builder;

public record MemberResponse (
        Long id,
        String email,
        String nickname
){
    @Builder
    public MemberResponse {
    }
}
