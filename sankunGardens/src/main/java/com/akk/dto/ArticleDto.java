package com.akk.dto;

import com.akk.bean.Article;
import lombok.Data;


/**
 * Created by KHM
 * 2017/10/10 20:00
 */
@Data
public class ArticleDto extends Article{

    private String fname;

    private String zname;

}
