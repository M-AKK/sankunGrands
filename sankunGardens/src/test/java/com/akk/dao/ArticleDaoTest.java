package com.akk.dao;

import com.akk.bean.Article;
import com.akk.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
@Slf4j
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void selectById() throws Exception {
        Article result = articleDao.selectById(new Long(1));
        log.info("【前端菜单查询一个】 result={}", JsonUtil.toJson(result));
        Assert.assertNotNull(result);
    }

}