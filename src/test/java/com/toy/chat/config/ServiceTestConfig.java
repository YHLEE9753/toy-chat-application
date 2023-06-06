package com.toy.chat.config;

import com.toy.chat.domain.member.model.Member;
import com.toy.chat.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class ServiceTestConfig extends MySqlContainerSetting {
    @Autowired
    public MemberRepository memberRepository;

    public Member member;

    public Member otherMember;

    @BeforeEach
    void init() {
        this.member = memberRepository.save(
                Member
                        .builder()
                        .email("test@gmail.com")
                        .nickName("nickname")
                        .password("abc1234")
                        .build()
        );

        this.otherMember = memberRepository.save(
                Member
                        .builder()
                        .email("test2@gmail.com")
                        .nickName("nickname2")
                        .password("1234abc")
                        .build()
        );
    }

    @AfterEach
    void after(){
        memberRepository.deleteAll();
    }
}
