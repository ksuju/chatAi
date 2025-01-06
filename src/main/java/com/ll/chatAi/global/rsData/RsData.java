package com.ll.chatAi.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * packageName    : com.ll.chatAi.global.rsData
 * fileName       : RsData
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Getter
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        return new RsData<>(resultCode, msg, data);
    }

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public Optional<RsData<T>> optional() {
        return Optional.of(this);
    }

    public <T> RsData<T> newDataOf(T data) {
        return new RsData<T>(getResultCode(), getMsg(), data);
    }
}
