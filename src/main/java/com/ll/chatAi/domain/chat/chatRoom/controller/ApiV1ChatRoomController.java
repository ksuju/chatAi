package com.ll.chatAi.domain.chat.chatRoom.controller;

import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatRoom.controller
 * fileName       : ApiV1ChatRoomController
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
public class ApiV1ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("")
    public RsData<?> chatRoomList() {

        // 채팅방 목록 조회
        chatRoomService.list();

        return RsData.of("S-1","채팅방 목록 조회완료");
    }

    @GetMapping("/{roomId}")
    public RsData<ChatRoom> chatRoom(@PathVariable Long roomId) {

        ChatRoom chatRoom = chatRoomService.findRoom(roomId);

        return RsData.of("S-1", "단건 채팅방 조회완료", chatRoom);
    }

    @PostMapping("")
    public RsData<ChatRoom> createChatRoom(@RequestBody String name) {

        // 채팅방 생성
        ChatRoom chatRoom = chatRoomService.create(name);

        return RsData.of("S-1","채팅방 생성 완료", chatRoom);
    }
}
