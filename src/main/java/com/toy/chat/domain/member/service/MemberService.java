package com.toy.chat.domain.member.service;

import com.toy.chat.domain.member.model.Member;
import com.toy.chat.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String updateMemberName(Long memberId, String newName) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> {
            throw new RuntimeException();
        });
        return null;
    }
}
