package com.gcxy.jk.shixunyi.advice;

import cn.hutool.json.JSONUtil;
import com.gcxy.jk.shixunyi.base.ListResponse;
import com.gcxy.jk.shixunyi.base.ObjectResponse;
import com.gcxy.jk.shixunyi.base.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 包装返回类型
 * @author hujinghua
 * @date 2022/8/31 20:52
 */
@Slf4j
@ControllerAdvice
public class ResponseBodyWrapAdvice implements HandlerMethodReturnValueHandler {

    /**
     * 判断返回结果是否需要再次封装
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        // 是否在方法上加了@ResponseBody注解
        boolean hasResponseBody = methodParameter.getMethodAnnotation(ResponseBody.class) != null;
        // 是否在类上加了@RestController注解
        boolean hasRestController = methodParameter.getContainingClass().getAnnotation(RestController.class) != null;
        return hasResponseBody || hasRestController;
    }

    /**
     * 包装返回的结果
     * @param body
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @throws Exception
     */
    @Override
    public void handleReturnValue(Object body, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        log.info("请求成功，返回消息自定义转换");
        modelAndViewContainer.setRequestHandled(true);
        HttpServletResponse response =  nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        // 判断在Controller接口中是否直接返回了RestResponse，ObjectResponse，ListResponse类型
        if(!(body instanceof RestResponse)) {
            if(body instanceof List) {
                // 返回的数据是否是list
                body = ListResponse.ok((List) body);
            } else if(body instanceof Object) {
                // 返回的数据类型是否是对象
                body = ObjectResponse.ok(body);
            } else if(body == null) {
                body = ObjectResponse.ok(null);
            }
        }

        // 把封装完的数据返回到客户端
        try(PrintWriter writer = response.getWriter();){
            writer.write(JSONUtil.parseObj(body).toString());
            writer.flush();
        } catch (IOException ex) {
            log.error("统一格式返回", ex);
        }
    }


    /**
     * 统一异常处理
     * @param e
     * @return
     */
      @ResponseBody
      @ExceptionHandler(Exception.class)
      public RestResponse myException(Exception e) {
        e.printStackTrace();
        RestResponse response = ObjectResponse.failed(e.getMessage());
        return response;
      }


    /**
     * 统一错误处理
     * @param e
     * @return
     */
      @ExceptionHandler(Throwable.class)
      @ResponseBody
      public RestResponse allException(Throwable e) {
        RestResponse response = ObjectResponse.failed(e.getMessage());
        return response;
      }

}
