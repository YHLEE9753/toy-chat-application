package com.toy.chat.domain.chat.service;

import com.toy.chat.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private ChatRoomRepository chatRoomRepository;
}
