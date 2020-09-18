package com.libaoguang.cn.carcommon.vo.page;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageVO implements Serializable {
    /**
     * 分页相关
     */
    private Integer page;
    private Integer rows;
    private Integer totalPage;
    private Integer totalCount;

}
