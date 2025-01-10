package com.ll.chatAi.member.member.service;

import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * packageName    : com.ll.chatAi.member.member.service
 * fileName       : MemberServiceTest
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @DisplayName("회원가입")
    @Test
    void t1() {
        Member member = memberService.signup("usernew", "1234");
        assertThat(member.getId()).isGreaterThan(0L);
    }
}
