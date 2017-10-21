package com.akk.service;

import com.akk.bean.ApiMenu;
import com.akk.dto.ApiMenuDto;

import java.util.List;

/**
 * 前端菜单的具体实现方法
 * Created by KHM
 * 2017/10/1 18:05
 */
public interface ApiMenuService {

    //获取所有栏目列表
    List<ApiMenuDto> getMenuList();

    //获取所有子栏目列表
    List<ApiMenu> getApiFMenuList();

    //获取所有子栏目列表
    List<ApiMenu> getApiZMenuList();
}
