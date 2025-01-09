package com.ll.chatAi.domain.chat.article.entity;

import com.ll.chatAi.domain.chat.comment.entity.Comment;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.tag.entity.ArticleTag;
import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

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
//    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)  // 배치사이즈 설정과 관련
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

    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude // 순환 참조 방지
    private List<ArticleTag> tags = new ArrayList<>();
    public void addTag(String tagContent) {
        ArticleTag tag = ArticleTag.builder()
                .article(this)
                .content(tagContent)
                .build();
        tags.add(tag);
    }

    public void addTags(String... tagContents) {
        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }

    public String getTagsStr() {
        String tagstr = tags
                .stream()
                .map(ArticleTag::getContent)
                .collect(Collectors.joining(" #"));

        if(tagstr.isBlank()) {
            return "";
        }

        return "#" + tagstr;
    }

//    public void removeComment(Comment comment) {  안써서 주석
//        if (this.comments != null) {
//            this.comments.remove(comment);
//            comment.setArticle(null); // 연관 관계 끊기
//        }
//    }
}
