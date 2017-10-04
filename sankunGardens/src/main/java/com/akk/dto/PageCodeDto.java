package com.akk.dto;

import com.akk.constant.PageCodeEnum;
import lombok.Data;

/**
 * 返给前端的包装类
 */
@Data
public class PageCodeDto {
    
    private Integer code;
    private String msg;
    
    public PageCodeDto() {

    }
    
    public PageCodeDto(PageCodeEnum pageCodeEnum) {
	this.code = pageCodeEnum.getCode();
	this.msg = pageCodeEnum.getMsg();
    }

}