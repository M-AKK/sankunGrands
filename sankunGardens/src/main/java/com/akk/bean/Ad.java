package com.akk.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * 图片列表实体
 * @author KHM
 */
@JsonInclude(Include.NON_NULL)
@Data
public class Ad extends BaseBean {
    private Long id;
    private String title;
    private String description;
    private String imgFileName;
    private Long weight;
    private Long imgGroupId;
    /**
     * 另一张表的
     */
    private ImgGroup imgGroup;
}