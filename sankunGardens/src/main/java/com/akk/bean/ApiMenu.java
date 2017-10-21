package com.akk.bean;

import lombok.Data;

/**
 * 前端菜单实体表
 * Created by KHM
 * 2017/10/1 16:05
 */
@Data
public class ApiMenu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private Integer orderNum;
    private String link;//点击跳转到哪个页面
}
