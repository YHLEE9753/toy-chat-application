package com.toy.chat.domain.member.repository;

import com.toy.chat.domain.member.model.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findMemberById(Long memberId);

    Optional<Member> findMemberByEmail(String email);

    Optional<Member> findMemberByNickName(String nickname);
}
