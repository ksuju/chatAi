package com.ll.chatAi.domain.chat.article.controller;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.controller
 * fileName       : ArticleController
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@RestController
@RequestMapping("/api/v1/chat/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("")
    public RsData<Article> post(@RequestBody Article article) {

        return articleService.write(article.getArticleId()
                ,article.getTitle()
                ,article.getContent());
    }

    @GetMapping("/{articleId}")
    public RsData<Member> getArticle(@PathVariable Long articleId) {
        Article article = articleService.findById(articleId).get();
        Member member = article.getAuthor();
        return RsData.of("200","완료", member);
    }
}
