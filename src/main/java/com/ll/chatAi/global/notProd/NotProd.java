package com.ll.chatAi.global.notProd;

import com.ll.chatAi.domain.chat.article.entity.Article;
import com.ll.chatAi.domain.chat.article.service.ArticleService;
import com.ll.chatAi.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatAi.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatAi.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chatAi.domain.chat.comment.service.CommentService;
import com.ll.chatAi.domain.chat.member.entity.Member;
import com.ll.chatAi.domain.chat.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

/**
 * packageName    : com.ll.chatAi.global.notProd
 * fileName       : NotProd
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Configuration
@Profile("!prod")
public class NotProd {
    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService,
                                         ChatMessageService chatMessageService,
                                         MemberService memberService,
                                         ArticleService articleService,
                                         CommentService commentService) {
        return args -> {
            // 저장된 모든 데이터 삭제 후 더미 데이터 생성
            // application.yml jpa 설정에서 ddl-auto: create로 설정해서 데이터 쌓이는 문제 해결
//            chatMessageService.deleteAll();
//            chatRoomService.deleteAll();

            ChatRoom chatRoom1 = chatRoomService.create("공부");
            ChatRoom chatRoom2 = chatRoomService.create("식사");
            ChatRoom chatRoom3 = chatRoomService.create("휴식");

            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();
            Member member3 = memberService.join("user3", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

            commentService.addComment(member1, article1, "댓글1");
            commentService.addComment(member1, article1, "댓글2");

            commentService.addComment(member1, article2, "댓글3");
            commentService.addComment(member1, article2, "댓글4");
            commentService.addComment(member1, article2, "댓글5");

            commentService.addComment(member1, article3,"댓글5");
            commentService.addComment(member1, article3,"댓글6");
            commentService.addComment(member1, article3,"댓글7");
            commentService.addComment(member1, article3,"댓글8");
            commentService.addComment(member1, article3,"댓글9");
            commentService.addComment(member1, article3,"댓글10");
            commentService.addComment(member1, article3,"댓글11");
            commentService.addComment(member1, article3,"댓글12");

            // 댓글 수정 테스트
            article1.getComments().forEach(comment -> {
                String modifiedContent = comment.getContent() + " (수정됨)";
                commentService.modifyComment(comment, modifiedContent);
                System.out.println("수정된 댓글: " + comment);
            });


            IntStream.rangeClosed(1, 100).forEach(num -> {
                chatMessageService.add(chatRoom1, "TEST", "메시지" + num);
            });

            System.out.println("Not Prod");
        };
    }

}
