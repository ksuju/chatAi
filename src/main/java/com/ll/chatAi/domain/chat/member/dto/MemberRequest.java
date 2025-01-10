package com.ll.chatAi.domain.chat.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.dto
 * fileName       : MemberRequest
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
@Data
@AllArgsConstructor
public class MemberRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
