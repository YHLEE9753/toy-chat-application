package com.toy.chat.domain.chat2;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {

    private final ChatRoomRepository repository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public List<ChatRoomDTO> rooms(){
        log.info("# All Chat Rooms");

        return repository.findAllRooms();
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String name){
        log.info("# Create Chat Room , name: " + name);
        repository.createChatRoomDTO(name);

        return "clear";
    }

    //채팅방 조회
    @GetMapping("/room")
    public ChatRoomDTO getRoom(String roomId){
        log.info("# get Chat Room, roomID : " + roomId);

        return repository.findRoomById(roomId);
    }
}