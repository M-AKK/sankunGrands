package com.akk.dao;

import com.akk.bean.ApiMenu;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/1 18:51
 */
public interface ApiMenuDao {

    /**
     * 查询所有前端菜单列表
     * @return
     */
    List<ApiMenu> getMenuList();
}
