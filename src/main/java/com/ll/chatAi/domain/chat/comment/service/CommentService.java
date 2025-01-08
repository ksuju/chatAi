package com.ll.chatAi.domain.chat.comment.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.repository.ArticleRepository;
import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.comment.repository.CommentRepository;
import com.ll.chatAi.domain.chat.member.entity.Member;
import jakarta.transaction.Transactional;
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
    private final ArticleRepository articleRepository;

    //article2.addComment(member1, "댓글 입니다.");
    public void addComment(Member member, Article article, String content) {
        long memberId = member.getId();
        Comment comment = Comment.builder()
                .memberId(memberId)
                .content(content)
                .build();

        article.addComment(comment); // 양방향 연관관계 설정
        commentRepository.save(comment); // 주인 엔티티 저장
    }

    //("1번 글의 댓글들을 수정한다.")
    //commentService.modifyComment(comment, comment.getContent() + "!!");
    @Transactional
    public void modifyComment(Comment comment, String content) {
        comment.setContent(content);
        commentRepository.save(comment);
    }
}
