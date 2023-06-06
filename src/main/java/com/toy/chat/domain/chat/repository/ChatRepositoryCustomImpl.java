package com.toy.chat.domain.chat.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatRepositoryCustomImpl implements ChatRoomRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
}
