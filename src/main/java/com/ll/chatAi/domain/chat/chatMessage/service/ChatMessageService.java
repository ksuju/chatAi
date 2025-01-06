package com.ll.chatAi.domain.chat.chatMessage.service;

import com.ll.chatAi.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatAi.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatMessage.service
 * fileName       : ChatMessageService
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public void messages(Long roomId) {
    }

    public void add(ChatRoom chatRoom, String writerName, String content) {

        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessageRepository.save(chatMessage);
    }

    // 모든 데이터 삭제
    public void deleteAll() {
        chatMessageRepository.deleteAll();
    }
}
