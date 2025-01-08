package com.ll.chatAi.domain.chat.comment.entity;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * packageName    : com.ll.chatAi.domain.chat.comment.entity
 * fileName       : Comment
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class Comment extends BaseEntity {
    @ManyToOne
    private Member member;

    @ManyToOne
    private Article article;

    private String content;
}
