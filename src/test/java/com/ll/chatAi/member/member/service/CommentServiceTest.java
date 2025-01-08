package com.ll.chatAi.member.member.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.comment.service.CommentService;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.ll.chatAi.member.member.service
 * fileName       : CommentServiceTest
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
public class CommentServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CommentService commentService;

    Logger logger = LoggerFactory.getLogger(CommentServiceTest.class);

    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    @Rollback(false)
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(2L).get();

        commentService.addComment(member1, article2,"댓글 입니다.");
    }

    @DisplayName("1번 글의 댓글들을 수정한다.")
    @Test
    void t6() {
        Article article = articleService.findById(1L).get();

        article.getComments().forEach(comment -> {
            logger.info("comment =====> " + comment);
            commentService.modifyComment(comment, comment.getContent() + "!!");
        });
    }

    @DisplayName("1번 글의 댓글 중 마지막 것을 삭제한다.")
    @Test
    void t7() {
        Article article = articleService.findById(1L).get();

        Comment lastComment = article.getComments().getLast();

        article.removeComment(lastComment);
    }
}
