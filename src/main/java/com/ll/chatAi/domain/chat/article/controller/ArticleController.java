package com.ll.chatAi.domain.chat.article.controller;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * packageName    : com.ll.chatAi.domain.chat.article.controller
 * fileName       : ArticleController
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */
@Controller
@RequestMapping("/api/v1/chat/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(
            @RequestParam(value = "kwType", defaultValue = "") List<String> kwTypes,
            @RequestParam(defaultValue = "") String kw,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        Map<String, Boolean> kwTypesMap = kwTypes
                .stream()
                .collect(Collectors.toMap(
                        kwType -> kwType,
                        kwType -> true
                ));

        // log.debug("kwTypesMap: {}", kwTypesMap);
        Page<Article> itemsPage = articleService.search(kwTypes, kw, pageable);
        model.addAttribute("itemsPage", itemsPage);
        model.addAttribute("kwTypesMap", kwTypesMap);

        return "article/list";
    }
    @PostMapping("")
    public RsData<Article> post(@RequestBody Article article) {

        return articleService.write(article.getAuthor().getId()
                ,article.getTitle()
                ,article.getContent());
    }

    @GetMapping("/{articleId}")
    public RsData<Member> getArticle(@PathVariable Long articleId) {
        Article article = articleService.findById(articleId).get();
        Member member = article.getAuthor();
        return RsData.of("200","완료", member);
    }
}
