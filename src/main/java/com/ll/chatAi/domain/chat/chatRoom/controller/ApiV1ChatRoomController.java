package com.ll.chatAi.domain.chat.chatRoom.controller;

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
public class ApiV1ChatRoomController {

    @GetMapping("")
    public String chatRoomList() {
        return "채팅방 목록 조회완료";
    }

    @GetMapping("/{roomId}")
    public String chatRoom() {
        return "1번 채팅방 조회완료";
    }

    @PostMapping("")
    public String createChatRoom() {
        return "채팅방 생성완료";
    }

    @GetMapping("/{roomId}/messages")
    public String message(@RequestBody String afterChatMessageId) {
        System.out.println("id : " + afterChatMessageId);
        return "1번 채팅방 메시지 목록 조회 완료";
    }

    @PostMapping("/{roomID}/messages")
    public String createChat() {
        return "채팅방 메시지 생성 완료";
    }
}
