package com.toy.chat.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public record MemberUpdateRequest(
        @NotBlank
        String nickname
) {
        @Builder
        public MemberUpdateRequest {
        }
}
