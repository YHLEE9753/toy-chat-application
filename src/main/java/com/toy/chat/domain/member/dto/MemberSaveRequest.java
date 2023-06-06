package com.toy.chat.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public record MemberSaveRequest(
        @NotBlank
        String email,
        @NotBlank
        String nickname,
        @NotBlank
        String password
) {
    @Builder
    public MemberSaveRequest {
    }
}