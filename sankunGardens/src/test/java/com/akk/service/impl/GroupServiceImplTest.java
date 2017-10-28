package com.akk.service.impl;

import com.akk.dto.GroupDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
@Slf4j
public class GroupServiceImplTest {

    @Autowired
    private GroupServiceImpl groupService;

    @Test
    public void getByIdWithMenu() throws Exception {

        GroupDto groupDto = groupService.getByIdWithMenu(new Long(1));
        Assert.assertNotNull(groupDto);
    }

}
