package com.toy.chat.domain.member.model;

import static lombok.AccessLevel.*;

import java.util.regex.Pattern;

import com.toy.chat.global.error.exception.MemberException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class Email {
    private static final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private String address;

    public Email(String emailAddress) {
        String lowerCasedEmail = emailAddress.toLowerCase();
        validateEmailPattern(lowerCasedEmail);
        this.address = lowerCasedEmail;
    }

    private final void validateEmailPattern(String email) {
        boolean matches = Pattern.matches(EMAIL_REGEX, email);
        if (!matches) {
            throw MemberException.invalidEmail(email);
        }
    }
}

