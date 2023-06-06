package com.toy.chat.domain.member.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.chat.domain.member.model.Member;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.toy.chat.domain.member.model.QMember.member;

@RequiredArgsConstructor
public class CustomMemberRepositoryImpl implements CustomMemberRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Member> findMemberById(Long memberId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(member)
                        .where(member.id.eq(memberId), isNotDeleted())
                        .fetchOne()
        );
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(member)
                        .where(member.email.eq(email), isNotDeleted())
                        .fetchOne()
        );
    }

    @Override
    public Optional<Member> findMemberByNickName(String nickname) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(member)
                        .where(member.nickName.eq(nickname), isNotDeleted())
                        .fetchOne()
        );
    }

    private BooleanExpression isNotDeleted() {
        return member.isDeleted.isFalse();
    }
}
