package com.toy.chat.global.error.exception;

import com.toy.chat.global.error.dto.ErrorCode;

import java.text.MessageFormat;


public class MemberException extends BusinessException {

    protected MemberException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected MemberException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public static MemberException invalidEmail(String email) {
        return new MemberException(ErrorCode.INVALID_EMAIL,
                MessageFormat.format("이메일이 유효하지 않습니다. (email: {0})", email));
    }

    public static MemberException notFoundMember(Long memberId) {
        return new MemberException(ErrorCode.NOT_FOUND_MEMBER,
                MessageFormat.format("회원을 찾을 수 없습니다. (id: {0})", memberId));
    }

    public static MemberException nicknameDuplication(String nickname) {
        return new MemberException(ErrorCode.NICKNAME_DUPLICATION,
                MessageFormat.format("이미 존재하는 닉네임 입니다. (nickname: {0})", nickname));
    }

    public static MemberException emailDuplication(String email) {
        return new MemberException(ErrorCode.REGISTERED_MEMBER,
                MessageFormat.format("이미 등록된 회원 입니다. (email: {0})", email));
    }

}
