package com.yeon.standard.common.response;

import com.yeon.standard.common.exception.ExceptionCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

public class Result {

  private Result() {}

  public static ResponseEntity<ApiResult<?>> created() {
    return ResponseEntity.status(201).body(ApiResult.of(ExceptionCode.SUCCESS_NORMAL));
  }

  public static <T> ResponseEntity<ApiResult<T>> created(final T data) {
    return ResponseEntity.status(201).body(ApiResult.of(ExceptionCode.SUCCESS_NORMAL, data));
  }

  public static ResponseEntity<ApiResult<?>> ok() {
    return ResponseEntity.status(200).body(ApiResult.of(ExceptionCode.SUCCESS_NORMAL));
  }

  public static <T> ResponseEntity<ApiResult<T>> ok(final T data) {
    return ResponseEntity.status(200).body(ApiResult.of(ExceptionCode.SUCCESS_NORMAL, data));
  }

  public static ResponseEntity<ApiResult<?>> error() {
    return ResponseEntity.status(200).body(ApiResult.of(ExceptionCode.ERROR_SYSTEM));
  }

  public static ResponseEntity<ApiResult<?>> error(final ExceptionCode exceptionCode) {
    Assert.notNull(exceptionCode, "Parameter `exceptionCode` must note be null");
    return ResponseEntity.status(200).body(ApiResult.of(exceptionCode));
  }
}
