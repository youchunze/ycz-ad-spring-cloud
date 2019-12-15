package com.ycz.ad.advice;

import com.ycz.ad.exception.AdException;
import com.ycz.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hyczzz
 * @date: 2019/12/8 0008 22:42
 * @description:
 */
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req,
                                                     AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1,
                "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
