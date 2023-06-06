package com.toy.chat.domain.chat.controller;

import com.toy.chat.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chatroom")
@RequiredArgsConstructor
public class ChatRoomController {
    private ChatRoomService chatRoomService;

    @GetMapping("/rooms")
    public String getRooms(){
        return "chat/rooms";
    }

    @GetMapping(value = "/room")
    public String getRoom(Long chatRoomId, String nickname, Model model){

        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("nickname", nickname);

        return "chat/room";
    }
}