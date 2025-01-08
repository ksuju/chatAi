package com.ll.chatAi.domain.chat.article.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.repository.ArticleRepository;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.service
 * fileName       : ArticleService
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
public class ArticleService {
    private final ArticleRepository articleRepository;

    public RsData<Article> write(Long articleId, String subject, String content) {

        Article article = Article.builder()
                .articleId(articleId)
                .subject(subject)
                .content(content)
                .build();

        articleRepository.save(article);

        return RsData.of("200","포스팅완료", article);
    }
}
