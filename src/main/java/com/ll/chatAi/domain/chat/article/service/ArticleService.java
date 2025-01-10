package com.ll.chatAi.domain.chat.article.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.repository.ArticleRepository;
import com.ll.chatAi.domain.chat.comment.repository.CommentRepository;
import com.ll.chatAi.domain.chat.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Article write(String title, String content) {

        Article article = Article.builder()
                .author(Member.builder().id(1L).build())
                .title(title)
                .content(content)
                .build();

        return articleRepository.save(article);
    }

    public Optional<Article> findById(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);

        return article;
    }

    //articleService.modify(article, "수정된 제목", "수정된 내용")
    @Transactional
    public Article modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
//        articleRepository.save(article);
        return article;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        this.articleRepository.deleteById(id);
    }
}
