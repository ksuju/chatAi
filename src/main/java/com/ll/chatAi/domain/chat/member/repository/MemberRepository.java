package com.ll.chatAi.domain.chat.member.repository;

import com.ll.chatAi.domain.chat.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.repository
 * fileName       : MemberRepository
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
    Optional<Member> findByRefreshToken(String refreshToken);
}
