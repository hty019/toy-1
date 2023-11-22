package com.yeon.standard.common.exception;

import java.text.MessageFormat;
import lombok.Getter;

@Getter
public enum ExceptionCode {
  SUCCESS_NORMAL("S000", "성공"),
  ERROR_SYSTEM("E000", "실패"),
  FAIL_INVALID_REQUEST("F000", "올바르지 않은 요청"),
  FAIL_INVALID_PARAMETER("F001", "올바르지 않은 파라미터"),
  FAIL_NO_DATA_SUCCESS("F002", "처리건 없음.");
  private final String code;
  private final String message;

  ExceptionCode(final String code, final String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String toString() {
    return MessageFormat.format("{0}({1}, {2})", this.name(), this.code, this.message);
  }
}
