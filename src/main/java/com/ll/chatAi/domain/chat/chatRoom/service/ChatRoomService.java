package com.ll.chatAi.domain.chat.chatRoom.service;

import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatRoom.service
 * fileName       : ChatRoomService
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
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    // 채팅방 목록 조회
    public void list() {
        chatRoomRepository.findAll();
    }

    // 채팅방 찾기
    public ChatRoom findRoom(Long roomId) {
        return chatRoomRepository.findById(roomId).get();
    }

    // 채팅방 생성
    public ChatRoom create(String name) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(name)
                .build();

        return chatRoomRepository.save(chatRoom);
    }

    // 모든 데이터 삭제
    public void deleteAll() {
        chatRoomRepository.deleteAll();
    }
}
