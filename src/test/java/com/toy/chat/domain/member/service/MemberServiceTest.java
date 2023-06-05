package com.toy.chat.domain.member.service;

import com.toy.chat.config.MySqlContainerSetting;
import com.toy.chat.domain.member.model.Member;
import com.toy.chat.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class MemberServiceTest extends MySqlContainerSetting {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Member 이름 바꾸기")
    void changeMemberName(){
        Member member = new Member("yong");
        memberRepository.save(member);
        member.changeName("hoon");

        Assertions.assertThat(member.getName()).isEqualTo("hoon");
    }

}