package com.ll.chatAi.member.member.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.comment.service.CommentService;
import com.ll.chatAi.domain.chat.tag.entity.ArticleTag;
import com.ll.chatAi.domain.chat.tag.service.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * packageName    : com.ll.chatAi.member.member.service
 * fileName       : TagServiceTest
 * author         : sungjun
 * date           : 2025-01-09
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-09        kyd54       최초 생성
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class TagServiceTest {
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @DisplayName("1번 게시물의 태그(String)를 반환한다.")
    @Test
    void t9() {
        Article article1 = articleService.findById(1L).get();

        String tagsStr = article1.getTagsStr();

        assertThat(tagsStr).isEqualTo("#자바 #백엔드");
    }

    @DisplayName("1번 게시물 toString")
    @Test
    void t10() {
        Article article1 = articleService.findById(1L).get();

        System.out.println(article1);
    }


    @DisplayName("1번 회원이 작성한 댓글들")
    @Test
    void t11() {
        List<Comment> articleComments = commentService.findByAuthorId(1L);

        assertThat(articleComments.size()).isGreaterThan(0);
    }

    @DisplayName("1번 회원이 작성한 태그들")
    @Test
    void t12() {
        List<ArticleTag> articleTags = tagService.findByAuthorId(1L);

        assertThat(articleTags.size()).isGreaterThan(0);
    }
//
//    @DisplayName("아이디가 user1 인 회원이 작성한 태그들")
//    @Test
//    void t13() {
//        List<ArticleTag> articleTags = articleTagService.findByAuthorUsername("user1");
//
//        assertThat(articleTags.size()).isGreaterThan(0);
//    }
}
