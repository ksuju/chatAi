package com.ll.chatAi.domain.chat.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.dto
 * fileName       : ArticleModifyRequest
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
@Data
public class ArticleModifyRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
