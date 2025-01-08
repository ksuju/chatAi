package com.ll.chatAi.domain.chat.article.entity;

import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.entity
 * fileName       : Article
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
public class Article extends BaseEntity {
    private long articleId;
    private String title;
    private String content;
    @ManyToOne
    private Member author;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude // 순환 참조 방지
    private List<Comment> comments;

    public void addComment(Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
        comment.setArticle(this); // 연관 관계 설정
    }

    public void removeComment(Comment comment) {
        if (this.comments != null) {
            this.comments.remove(comment);
            comment.setArticle(null); // 연관 관계 끊기
        }
    }
}
