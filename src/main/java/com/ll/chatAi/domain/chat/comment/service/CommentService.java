package com.ll.chatAi.domain.chat.comment.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.comment.repository.CommentRepository;
import com.ll.chatAi.domain.chat.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.ll.chatAi.domain.chat.comment.service
 * fileName       : CommentService
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
public class CommentService {
    private final CommentRepository commentRepository;

    //article2.addComment(member1, "댓글 입니다.");
    public void addComment(Member member, Article article, String content) {
        Comment comment = Comment.builder()
                .member(member)
                .article(article)
                .content(content)
                .build();

        commentRepository.save(comment);
    }
}
