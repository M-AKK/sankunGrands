package com.akk.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * Created by KHM
 * 2017/10/10 19:58
 */
@Data
@DynamicUpdate
public class Article extends BaseBean{

    private Long id;
    private String author;
    private String title;
    private String content;
    private Long fid;
    private Long zid;
    private Long weight;
    private String imgurl;//有可能有图片
    private Date updateTime;

}
