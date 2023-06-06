package com.toy.chat.domain.member.service;

import com.toy.chat.domain.member.dto.MemberResponse;
import com.toy.chat.domain.member.model.Member;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMapper {

    public static MemberResponse toMemberResponse(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickName())
                .build();
    }
}
