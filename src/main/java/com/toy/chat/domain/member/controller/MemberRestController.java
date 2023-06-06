package com.toy.chat.domain.member.controller;

import com.toy.chat.domain.member.dto.MemberResponse;
import com.toy.chat.domain.member.dto.MemberSaveRequest;
import com.toy.chat.domain.member.dto.MemberUpdateRequest;
import com.toy.chat.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMember(
            @PathVariable Long memberId
    ) {
        return ResponseEntity
                .ok()
                .body(memberService.getMember(memberId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> saveMember(
            @Valid @RequestBody MemberSaveRequest memberSaveRequest
    ) {
        MemberResponse memberResponse = memberService.save(memberSaveRequest);

        return ResponseEntity
                .ok()
                .body(memberResponse);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMember(
            @Valid @RequestBody MemberUpdateRequest memberUpdateRequest, @PathVariable Long memberId
    ) {
        MemberResponse memberResponse = memberService.editMember(memberId, memberUpdateRequest);

        return ResponseEntity
                .ok()
                .body(memberResponse);
    }

}
