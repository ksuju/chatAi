package com.ll.chatAi.domain.chat.member.service;

import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.repository.MemberRepository;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
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

    public RsData<Member> join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();
        memberRepository.save(member);
        return RsData.of("200","회원가입완료", member);
    }

    //Member member1 = memberService.findById(1L).get();
    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
