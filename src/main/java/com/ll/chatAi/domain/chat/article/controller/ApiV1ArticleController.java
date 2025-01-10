package com.ll.chatAi.domain.chat.article.controller;

import com.ll.chatAi.domain.chat.article.dto.ArticleDto;
import com.ll.chatAi.domain.chat.article.dto.ArticleModifyRequest;
import com.ll.chatAi.domain.chat.article.dto.ArticleWriteRequest;
import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.global.rsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    // 다건 조회
    @GetMapping
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleService.findAll();

        List<ArticleDto> articleDtoList = articles.stream()
                .map(ArticleDto::new)
                .toList();

        return articleDtoList;
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable Long id) {
        Article article = articleService.findById(id).orElse(null);
        return new ArticleDto(article);
    }

    // 글 작성
    @PostMapping
    public RsData<ArticleDto> writeArticle(@Valid @RequestBody ArticleWriteRequest articleWriteRequest) {
        Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());

        return new RsData<>("200",
                "게시글이 작성되었습니다.",
                new ArticleDto(article));
    }

    // 단건 수정
    @PatchMapping("/{id}")
    public RsData<ArticleDto> updateArticle(@PathVariable Long id,
                                            @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.findById(id).orElse(null);
        Article modifiedArticle = this.articleService.modify(article, articleModifyRequest.getTitle(), articleModifyRequest.getContent());

        return new RsData<>("200",
                "게시글 수정에 성공했습니다.",
                new ArticleDto(modifiedArticle));
    }

    // 단건 삭제
    @DeleteMapping("/{id}")
    public RsData<Void> delete(@PathVariable Long id) {

        this.articleService.delete(id);

        return new RsData<>("200",
                "게시글 삭제에 성공했습니다");
    }

}
