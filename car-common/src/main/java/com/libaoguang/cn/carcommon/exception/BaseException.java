package com.libaoguang.cn.carcommon.exception;


import com.libaoguang.cn.carcommon.enums.ResultEnum;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private Integer code;
    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
