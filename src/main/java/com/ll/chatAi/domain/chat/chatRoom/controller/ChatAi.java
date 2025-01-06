package com.ll.chatAi.domain.chat.chatRoom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.ll.chatAi
 * fileName       : ChatController
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@RequestMapping("/api/v1/chat")
@RestController
@RequiredArgsConstructor
public class ChatAi {

    private final OpenAiChatModel openAiChatModel;  // OpenAi 라이브러리 객체

    @GetMapping("/ai")
    public Map<String, String> chat(@RequestBody String message) {
        Map<String, String> responses = new HashMap<>();

        String openAiResponse = openAiChatModel.call(message); // 내가 입력한 메시지를 집어넣음

        responses.put("OpenAI - ChatGPT 응답", openAiResponse);

        return responses;
    }

}
