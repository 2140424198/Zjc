package com.gcxy.jk.shixunyi.base;

import lombok.Data;

/** 
 * 基本响应包装类
 * @author hujinghua 
 * @date 2022/8/31 20:57
 */        
@Data
public abstract class RestResponse {

  private String code;
  private String message;

}
