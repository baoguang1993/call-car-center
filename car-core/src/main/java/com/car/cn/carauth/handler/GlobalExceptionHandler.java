package com.car.cn.carauth.handler;


import com.libaoguang.cn.carcommon.exception.BaseException;
import com.libaoguang.cn.carcommon.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handle(Exception e) {
        ResultVo resultVo;
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            resultVo = ResultVo.failResult(baseException);
            return resultVo;
        } else {
            resultVo = ResultVo.unknownResult(e.getMessage());
            return resultVo;
        }
    }
}
