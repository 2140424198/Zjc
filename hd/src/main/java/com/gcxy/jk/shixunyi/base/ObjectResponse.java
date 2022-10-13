package com.gcxy.jk.shixunyi.base;

import lombok.Data;

/**
 * 单对象响应包装类
 * @author hujinghua
 * @date 2022/8/31 20:57
 */
@Data
public class ObjectResponse<T> extends RestResponse{

  private T data;

  public static <T> ObjectResponse<T> ok(T data) {
    return restResult("SUCCESS", "成功", data);
  }

  public static <T> ObjectResponse<T> failed(String msg) {
    return restResult("FAILED", msg, null);
  }

  private static <T> ObjectResponse<T> restResult(String code, String msg, T data) {
    ObjectResponse<T> apiResult = new ObjectResponse<>();
    apiResult.setCode(code);
    apiResult.setMessage(msg);
    apiResult.setData(data);
    return apiResult;
  }

}
