package com.akk.Vo;

import lombok.Data;

/**
 * 由于日期需要转化
 * Created by KHM
 * 2017/10/21 16:10
 */
@Data
public class ArticleVo {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Long fid;
    private Long zid;
    private Long weight;
    private String imgurl;//有可能有图片
    private String updateTime;
    private String fname;
    private String zname;
}
