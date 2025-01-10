package com.ll.chatAi.domain.chat.member.controller;

import com.ll.chatAi.domain.chat.member.dto.MemberDto;
import com.ll.chatAi.domain.chat.member.dto.MemberRequest;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import com.ll.chatAi.global.jwt.JwtProvider;
import com.ll.chatAi.global.rsData.RsData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtProvider jwtProvider;

    // 회원가입
    @PostMapping("/signup")
    public RsData<MemberDto> signup(@Valid @RequestBody MemberRequest memberRequest) {

        Member member = memberService.signup(memberRequest.getUsername(), memberRequest.getPassword());

        return new RsData<>("200", "회원가입에 성공하였습니다.", new MemberDto(member));
    }

    // 로그인
    @PostMapping("/login")
    public RsData<Void> login(@Valid @RequestBody MemberRequest memberRequest,
                                HttpServletResponse response) {
        Member member = memberService.getMember(memberRequest.getUsername());
        // 토큰 생성
        String token = jwtProvider.genAccessToken(member);

        // 응답 데이터에 accessToken 이름으로 토큰을 발급
        response.addCookie(new Cookie("accessToken", token));

        return new RsData<>("200", "로그인에 성공했습니다.");
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
