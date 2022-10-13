package com.gcxy.jk.shixunyi.base;

import lombok.Data;

import java.util.List;

/**
 * 列表对象响应包装类
 * @author hujinghua
 * @date 2022/8/31 21:11
 */
@Data
public class ListResponse<T> extends RestResponse{

  private List<T> data;


  public static <T> ListResponse<T> ok(List<T> data) {
    return restResult("SUCCESS", "成功", data);
  }

  public static <T> ListResponse<T> failed(String msg) {
    return restResult("FAILED", msg, null);
  }


  private static <T> ListResponse<T> restResult(String code, String msg, List<T> data) {
    ListResponse<T> apiResult = new ListResponse<>();
    apiResult.setCode(code);
    apiResult.setMessage(msg);
    apiResult.setData(data);
    return apiResult;
  }
}
