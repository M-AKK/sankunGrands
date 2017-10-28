package com.akk.dao;

import com.akk.bean.ApiMenu;
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
public class ApiMenuDaoTest {

    @Autowired
    private  ApiMenuDao apiMenuDao;

    @Test
    public void selectById() throws Exception {
        ApiMenu result = apiMenuDao.selectById(new Long(1));
        log.info("【前端菜单查询一个】 result={}", JsonUtil.toJson(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void update() throws Exception {
        ApiMenu apiMenu = apiMenuDao.selectById(new Long(24));
        apiMenu.setName("修改测试");
        apiMenu.setUrl("");
        apiMenu.setOrderNum(77);
        apiMenu.setParentId(new Long(0));
        apiMenu.setLink("");
        int i = apiMenuDao.update(apiMenu);
        log.info("【前端菜单修改】 result={}", i);
        Assert.assertNotNull(i);
    }

    @Test
    public void delete() throws Exception {
        int i = apiMenuDao.delete(new Long(23));
        log.info("【前端菜单删除】 result={}", i);
        Assert.assertNotNull(i);

    }

    @Test
    public void insert() throws Exception {
        ApiMenu apiMenu = new ApiMenu();
        apiMenu.setName("测试");
        apiMenu.setUrl("articles/"+1+1);
        apiMenu.setParentId(new Long(1));
        apiMenu.setOrderNum(1);
        apiMenu.setLink("erji.html");
        int i = apiMenuDao.insert(apiMenu);
        log.info("【前端菜单插入】 result={}", i);
        Assert.assertNotNull(i);

    }

}