package com.ll.chatAi.domain.chat.member.dto;

import com.ll.chatAi.domain.chat.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.dto
 * fileName       : MemberDto
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
@Getter
@AllArgsConstructor
public class MemberDto {
    private String username;
    private String password;

    public MemberDto (Member member) {
        this.username = member.getUsername();
    }

}
