package com.ll.chatAi.domain.chat.chatRoom.entity;

import com.ll.chatAi.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * packageName    : com.ll.chatAi.entity
 * fileName       : chatEntity
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {

}
