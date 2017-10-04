package com.akk.service;

import com.akk.dto.ApiMenuDto;

import java.util.List;

/**
 * 前端菜单的具体实现方法
 * Created by KHM
 * 2017/10/1 18:05
 */
public interface ApiMenuService {

    List<ApiMenuDto> getMenuList();
}
