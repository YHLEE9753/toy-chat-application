package com.toy.chat.domain.member.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.toy.chat.config.ServiceTestConfig;
import com.toy.chat.domain.member.dto.MemberResponse;
import com.toy.chat.domain.member.dto.MemberUpdateRequest;
import com.toy.chat.domain.member.model.Email;
import com.toy.chat.domain.member.model.Member;
import com.toy.chat.global.error.exception.MemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class MemberServiceTest extends ServiceTestConfig {
    @Autowired(required = false)
    private MemberService memberService;

    @Test
    @DisplayName("이메일을 통해 유저를 가지고 온다")
    void testGetUserByEmail() {
        // given
        String testEmail = "test@gmail.com";

        // when
        Member member = memberService.getMember(new Email(testEmail))
                .orElseThrow(() -> MemberException.notFoundMember(1L));

        // then
        assertAll(
                () -> assertThat(member.getEmail()).isEqualTo("test@gmail.com"),
                () -> assertThat(member.getNickName()).isEqualTo("nickname"),
                () -> assertThat(member.getPassword()).isEqualTo("abc1234")
        );
    }

    @Test
    @DisplayName("멤버를 수정한다")
    void testInvalidPutMember() {
        // given
        Long memberId = member.getId();

        MemberUpdateRequest memberUpdateRequest = MemberUpdateRequest.builder()
                .nickname("test6")
                .build();

        // when
        MemberResponse memberResponse = memberService.editMember(memberId,memberUpdateRequest);

        // then
        assertAll(
                () -> assertThat(memberResponse.id()).isEqualTo(memberId),
                () -> assertThat(memberResponse.email()).isEqualTo("test@gmail.com"),
                () -> assertThat(memberResponse.nickname()).isEqualTo("test6"),
                () -> assertThat(member.getPassword()).isEqualTo("abc1234")
        );
    }

    @Test
    @DisplayName("멤버 수정 시 다른 유저와 동일한 닉네임은 사용할 수 없다")
    void testPutMember() {
        // given
        Long memberId = member.getId();
        String duplicatedNickname = otherMember.getNickName();

        MemberUpdateRequest memberUpdateRequest = MemberUpdateRequest.builder()
                .nickname(duplicatedNickname)
                .build();

        // when // then
        assertThrows(MemberException.class, () -> {
            memberService.editMember(memberId, memberUpdateRequest);
        });
    }
}