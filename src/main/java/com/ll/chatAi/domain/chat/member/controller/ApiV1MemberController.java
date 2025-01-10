package com.ll.chatAi.domain.chat.member.controller;

import com.ll.chatAi.domain.chat.member.dto.MemberDto;
import com.ll.chatAi.domain.chat.member.dto.MemberRequest;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import com.ll.chatAi.global.jwt.JwtProvider;
import com.ll.chatAi.global.rsData.RsData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        Cookie cookie = new Cookie("accessToken", token);
        cookie.setHttpOnly(true);   // 브라우저에서 쿠키 정보 건들 수 없음
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        String refreshToken = member.getRefreshToken();
        Cookie refreshTokenCookie  = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(60 * 60);
        response.addCookie(refreshTokenCookie);

        return new RsData<>("200", "로그인에 성공했습니다.");
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout() {

    }

    // 내 정보 불러오기
    @GetMapping("/me")
    public RsData<Member> myInfo(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String accessToken = "";

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("accessToken")) {
                accessToken = cookie.getValue();
            }
        }

        Map<String, Object> claims = jwtProvider.getClaims(accessToken);
        String username = (String)claims.get("username");

        Member member = this.memberService.getMember(username);

        return new RsData<Member>("200",
                "내 정보를 성공적으로 불러왔습니다.",
                member);
    }
}
