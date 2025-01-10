package com.ll.chatAi.domain.chat.article.dto;

import lombok.Data;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.dto
 * fileName       : ArticleWriteRequest
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
@Data
public class ArticleWriteRequest {
    private String title;
    private String content;
    // 작성자 id는 사용자 인증이 완료되면, 인가정보로 가져올 수 있음
}
