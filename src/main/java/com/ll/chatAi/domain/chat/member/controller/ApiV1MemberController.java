package com.ll.chatAi.domain.chat.member.controller;

import com.ll.chatAi.domain.chat.member.dto.MemberDto;
import com.ll.chatAi.domain.chat.member.dto.MemberRequest;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import com.ll.chatAi.global.rsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.controller
 * fileName       : MemberController
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public RsData<MemberDto> signup(@Valid @RequestBody MemberRequest memberRequest) {

        Member member = memberService.signup(memberRequest.getUsername(), memberRequest.getPassword());

        return RsData.of("200", "회원가입에 성공하였습니다.", new MemberDto(member));
    }

    // 로그인
    @PostMapping("/login")
    public void login() {
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout() {

    }

    // 내 정보 불러오기
    @GetMapping("/me")
    public void myInfo() {

    }
}
