package com.ll.chatAi.domain.chat.article.dto;

import com.ll.chatAi.domain.chat.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.dto
 * fileName       : ArticleDto
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
@Getter
public class ArticleDto {
    private final Long id;
    private final String title;
    private final String author;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.author = article.getAuthor().getUsername();
        this.createDate = article.getCreateDate();
        this.modifiedDate = article.getModifyDate();
    }
}
