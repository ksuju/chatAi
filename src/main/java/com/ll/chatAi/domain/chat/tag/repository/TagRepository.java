package com.ll.chatAi.domain.chat.tag.repository;

import com.ll.chatAi.domain.chat.tag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.tag.repository
 * fileName       : TagRepository
 * author         : sungjun
 * date           : 2025-01-09
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-09        kyd54       최초 생성
 */
public interface TagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle_Author_Id(Long memberId);
}
