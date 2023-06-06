package com.toy.chat.domain.member.service;

import com.toy.chat.domain.member.dto.MemberResponse;
import com.toy.chat.domain.member.dto.MemberSaveRequest;
import com.toy.chat.domain.member.dto.MemberUpdateRequest;
import com.toy.chat.domain.member.model.Email;
import com.toy.chat.domain.member.model.Member;
import com.toy.chat.domain.member.repository.MemberRepository;
import com.toy.chat.global.error.exception.MemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Optional<Member> getMember(Email email) {
        return memberRepository.findMemberByEmail(email.getAddress());
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        Member member = memberRepository.findMemberById(id).orElseThrow(() -> MemberException.notFoundMember(id));

        return MemberMapper.toMemberResponse(member);
    }

    @Transactional
    public MemberResponse save(MemberSaveRequest memberSaveRequest) {
        checkDuplicatedEmail(memberSaveRequest.email());
        checkDuplicatedNickname(memberSaveRequest.nickname());

        Member member = Member.builder()
                .email(memberSaveRequest.email())
                .nickName(memberSaveRequest.nickname())
                .password(memberSaveRequest.password())
                .build();

        memberRepository.save(member);

        return MemberMapper.toMemberResponse(member);
    }

    @Transactional
    public MemberResponse editMember(Long memberId, MemberUpdateRequest memberUpdateRequest) {
        checkDuplicatedNickname(memberUpdateRequest.nickname(), memberId);
        Member member = memberRepository.findMemberById(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));
        member.change(memberUpdateRequest.nickname());

        return MemberMapper.toMemberResponse(member);
    }

    private void checkDuplicatedNickname(String nickname, Long memberId) {
        memberRepository.findMemberByNickName(nickname).ifPresent(member -> {
            if (!Objects.equals(member.getId(), memberId)) {
                throw MemberException.nicknameDuplication(nickname);
            }
        });
    }

    private void checkDuplicatedNickname(String nickname) {
        memberRepository.findMemberByNickName(nickname).ifPresent(member -> {
            throw MemberException.nicknameDuplication(nickname);
        });
    }

    private void checkDuplicatedEmail(String email) {
        memberRepository.findMemberByEmail(email).ifPresent(member -> {
            throw MemberException.emailDuplication(email);
        });
    }
}
