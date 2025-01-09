package com.ll.chatAi.domain.chat.tag.entity;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * packageName    : com.ll.chatAi.domain.chat.tag.entity
 * fileName       : Tag
 * author         : sungjun
 * date           : 2025-01-09
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-09        kyd54       최초 생성
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ArticleTag extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
    private String content;
}
