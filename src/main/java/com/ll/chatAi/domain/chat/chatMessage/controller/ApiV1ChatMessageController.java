package com.ll.chatAi.domain.chat.chatMessage.controller;

import com.ll.chatAi.domain.chat.chatMessage.request.MessageRequest;
import com.ll.chatAi.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatMessage.controller
 * fileName       : ApiV1ChatMessageContoller
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
public class ApiV1ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    // 채팅방 메시지 목록을 가져오는 로직 구현이 어려움
    @GetMapping("/{roomId}/messages")
    public RsData<List<ChatRoom>> messages(@PathVariable Long roomId) {

        // 저장부터 한 뒤에 구현하자, 저장 시 ChatRoom의 messages 리스트에 저장하는 로직 필요
        chatMessageService.messages(roomId);

        return RsData.of("S-1","채팅방 메시지 목록 조회 완료");
    }

    @PostMapping("/{roomId}/messages")
    public String createChat(@PathVariable Long roomId,
                             @RequestBody MessageRequest messageRequest) {

        ChatRoom chatRoom = chatRoomService.findRoom(roomId);

        chatMessageService.add(chatRoom,
                messageRequest.getWriterName(),
                messageRequest.getContent());

        return roomId + "번 채팅방 메시지 생성 완료";
    }
}
