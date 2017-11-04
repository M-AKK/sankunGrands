package com.akk.service.impl;

import com.akk.bean.ImgGroup;
import com.akk.dao.ArticleDao;
import com.akk.dao.ImgGroupDao;
import com.akk.service.ImgGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by KHM
 * 2017/10/10 20:27
 */
@Service
public class ImgGroupServiceImpl implements ImgGroupService{

    @Autowired
    private ImgGroupDao imgGroupDao;

    @Override
    public List<ImgGroup> select(){

        return imgGroupDao.select();
    }
}
