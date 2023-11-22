package com.yeon.standard.common.exception;

import com.yeon.standard.common.response.ApiResult;
import com.yeon.standard.common.response.Result;
import java.io.Serial;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  @Serial private static final long serialVersionUID = -6456306907752399859L;
  private ApiResult<?> apiResult = Result.ok().getBody();

  public BusinessException(final ExceptionCode exceptionCode) {
    super(exceptionCode.toString());
    this.setApiResult(exceptionCode);
  }

  private void setApiResult(final ExceptionCode exceptionCode) {
    this.apiResult = ApiResult.of(exceptionCode);
  }
}
