package com.ll.chatAi.domain.chat.member.entity;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.member.entity
 * fileName       : MemberEntity
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
public class Member extends BaseEntity {
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @ToString.Exclude // 순환 참조 방지
    private List<Article> articles;

    private String username;
    private String password;
}
