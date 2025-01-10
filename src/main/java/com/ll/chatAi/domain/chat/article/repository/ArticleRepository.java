package com.ll.chatAi.domain.chat.article.repository;

import com.ll.chatAi.domain.chat.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.repository
 * fileName       : ArticleRepository
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
