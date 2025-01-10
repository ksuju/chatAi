package com.ll.chatAi.domain.chat.member.service;

import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.service
 * fileName       : MemberService
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;  // 단방향 암호화 (복호화X)

    public Member signup(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        memberRepository.save(member);
        return member;
    }

    //Member member1 = memberService.findById(1L).get();
    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
