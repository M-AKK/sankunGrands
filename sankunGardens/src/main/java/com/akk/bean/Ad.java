package com.akk.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 *图片列表实体
 */
@JsonInclude(Include.NON_NULL)
@Data
public class Ad extends BaseBean {
    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;
    //另一张表的
    private ImgGroup imgGroup;
}