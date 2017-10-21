package com.akk.service;

import com.akk.bean.ImgGroup;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/10 20:26
 */
public interface ImgGroupService {

    /**
     * 查询所有图片分类
     * @return
     */
    List<ImgGroup> select();
}
