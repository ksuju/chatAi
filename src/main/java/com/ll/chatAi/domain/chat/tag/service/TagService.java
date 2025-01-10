package com.ll.chatAi.domain.chat.tag.service;

import com.ll.chatAi.domain.chat.tag.entity.ArticleTag;
import com.ll.chatAi.domain.chat.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.tag.service
 * fileName       : TagService
 * author         : sungjun
 * date           : 2025-01-09
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-09        kyd54       최초 생성
 */
@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;


    public List<ArticleTag> findByAuthorId(Long memberId) {
        List<ArticleTag> tags= new ArrayList<>();

        tagRepository.findByArticle_Author_Id(memberId);

        return tags;
    }
}
