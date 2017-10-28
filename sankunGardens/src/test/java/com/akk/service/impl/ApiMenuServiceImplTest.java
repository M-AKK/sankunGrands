package com.akk.service.impl;

import com.akk.dto.ApiMenuDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
@Slf4j
public class ApiMenuServiceImplTest {

    @Autowired
    private ApiMenuServiceImpl apiMenuService;

    @Test
    public void getMenuList() throws Exception {
        List<ApiMenuDto> menuDtoList = new ArrayList<ApiMenuDto>();
        menuDtoList = apiMenuService.getMenuList();

        Assert.assertNotNull(menuDtoList);
    }

}