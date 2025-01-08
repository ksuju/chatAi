package com.ll.chatAi.member.member.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.comment.service.CommentService;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import com.ll.chatAi.global.rsData.RsData;
import com.ll.chatAi.global.ut.Ut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * packageName    : com.ll.chatAi.member.member.service
 * fileName       : ArticleServiceTest
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
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CommentService commentService;

    @DisplayName("글 쓰기")
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1L, "제목", "내용");
        Article article = writeRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }

    @DisplayName("1번 글을 가져온다.")
    @Test
    void t2() {
        Article article = articleService.findById(1L).get();
        assertThat(article.getTitle()).isEqualTo("제목1");
    }

    @DisplayName("1번 글의 작성자의 username 은 user1 이다.")
    @Test
    void t3() {
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();

        assertThat(author.getUsername()).isEqualTo("user1");
    }

    @DisplayName("1번 글의 제목을 수정한다.")
    @Test
    void t4() {
        Article article = articleService.findById(1L).get();

        Ut.thread.sleep(1000);

        articleService.modify(article, "수정된 제목", "수정된 내용");

        Article article_ = articleService.findById(1L).get();

        assertThat(article_.getTitle()).isEqualTo("수정된 제목");
    }

    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    @Rollback(false)
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(2L).get();

        commentService.addComment(member1, article2,"댓글 입니다.");
    }
}
