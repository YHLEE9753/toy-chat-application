package com.toy.chat.domain.member.repository;

import com.toy.chat.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}