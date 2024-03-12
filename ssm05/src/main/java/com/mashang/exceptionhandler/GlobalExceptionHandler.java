package com.mashang.exceptionhandler;

import com.mashang.vo.ResultView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultView error(Exception e) {
        e.printStackTrace();

        ResultView resultView = new ResultView();
        resultView.setCode(1000);
        resultView.setMsg("系统出错");

        return resultView; // 视图: error.jsp
    }

}
