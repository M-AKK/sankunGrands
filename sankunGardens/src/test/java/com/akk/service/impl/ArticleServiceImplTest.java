package com.akk.service.impl;

import com.akk.Vo.ArticleVo;
import com.akk.dto.ArticleDto;
import com.akk.service.ArticleService;
import com.akk.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
@Slf4j
public class ArticleServiceImplTest {

    @Autowired
    private ArticleServiceImpl articleService;

    @Test
    public void searchByPage() throws Exception {
        ArticleDto articleDto = new ArticleDto();
        List<ArticleVo> articleVoList = articleService.searchByPage(articleDto);
        log.info("【后端分页的文章】result={}", JsonUtil.toJson(articleVoList));
        Assert.assertNotNull(articleVoList);
    }

    @Test
    public void getById() throws Exception {
        ArticleVo ArticleVo = articleService.getById(new Long(1));
        log.info("【后端分页的文章】result={}", JsonUtil.toJson(ArticleVo));
        Assert.assertNotNull(ArticleVo);
    }
}