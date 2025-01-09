package com.ll.chatAi.domain.chat.article.service;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.repository.ArticleRepository;
import com.ll.chatAi.domain.chat.comment.repository.CommentRepository;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.global.rsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // Pageable 페이징하는 내장 객체
    public Page<Article> search(List<String> kwTypes, String kw, Pageable pageable) {
        if (kwTypes.contains("title") && kwTypes.contains("body")) {
            return articleRepository.findByTitleContainingOrContentContaining(kw, kw, pageable);
        } else if (kwTypes.contains("title")) {
            return articleRepository.findByTitleContaining(kw, pageable);
        } else if (kwTypes.contains("body")) {
            return articleRepository.findByContentContaining(kw, pageable);
        }
        return articleRepository.findAll(pageable);
    }

    @Transactional
    public RsData<Article> write(Long memberId, String title, String content) {

        Article article = Article.builder()
                .author(Member.builder().id(memberId).build())
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);

        return RsData.of("200","포스팅완료", article);
    }

    public Optional<Article> findById(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);

        return article;
    }

    //articleService.modify(article, "수정된 제목", "수정된 내용")
    @Transactional
    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
