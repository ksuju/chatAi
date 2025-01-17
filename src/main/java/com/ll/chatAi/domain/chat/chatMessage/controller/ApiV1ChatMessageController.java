package com.ll.chatAi.domain.chat.chatMessage.controller;

import com.ll.chatAi.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatAi.domain.chat.chatMessage.request.MessageRequest;
import com.ll.chatAi.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.service.ChatRoomService;
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
@CrossOrigin(
//        origins = "https://cdpn.io"
        origins = "http://localhost:5173"
)
public class ApiV1ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    // 채팅방 메시지 목록 가져오기
    @GetMapping("/{roomId}/messages")
    public List<ChatMessage> messages(@PathVariable Long roomId,
                         @RequestParam(required = false) Long afterChatMessageId) {

        if(afterChatMessageId == null) {
            afterChatMessageId = 0L;
        }

        List<ChatMessage> chatMessages = chatMessageService.messages(roomId, afterChatMessageId);

        return chatMessages;
    }

    @PostMapping("/{chatRoomId}/messages")
    public ChatMessage createChat(@PathVariable Long chatRoomId,
                             @RequestBody MessageRequest messageRequest) {

        ChatRoom chatRoom = chatRoomService.findRoom(chatRoomId);

        ChatMessage chatMessage = chatMessageService.add(chatRoom,
                messageRequest.getWriterName(),
                messageRequest.getContent());

        return chatMessage;
    }
}
