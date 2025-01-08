package com.ll.chatAi.domain.chat.comment.repository;

import com.ll.chatAi.domain.chat.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.ll.chatAi.domain.chat.comment.repository
 * fileName       : CommentRepository
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
