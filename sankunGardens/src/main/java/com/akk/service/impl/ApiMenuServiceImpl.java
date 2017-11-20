package com.akk.service.impl;

import com.akk.bean.ApiMenu;
import com.akk.dao.ApiMenuDao;
import com.akk.dto.ApiMenuDto;
import com.akk.service.ApiMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端菜单列表的返回
 * Created by KHM
 * 2017/10/1 18:05
 */
@Service
public class ApiMenuServiceImpl implements ApiMenuService {

    @Autowired
    private ApiMenuDao apiMenuDao;

    /**
     * 返回前端菜单列表
     * @return
     */
    @Override
    public List<ApiMenuDto> getMenuList() {
        List<ApiMenuDto> apiMenuDtoList = new ArrayList<ApiMenuDto>();

        for(ApiMenu apiMenu : apiMenuDao.getMenuList()){
            ApiMenuDto apiMenuDto = new ApiMenuDto();
            apiMenuDtoList.add(apiMenuDto);
            BeanUtils.copyProperties(apiMenu,apiMenuDto);
        }
        return apiMenuDtoList;
    }

    /**
     * 返回所有父栏目的name
     * @return
     */
    @Override
    public List<ApiMenu> getApiFMenuList(){
        return apiMenuDao.getFApiMenuList();
    }

    /**
     * 返回所有子栏目的name
     * @return
     */
    @Override
    public List<ApiMenu> getApiZMenuList(){
        return apiMenuDao.getZApiMenuList();
    }

    @Override
    public boolean modify(Long id, String name, Integer orderNum) {
        //ApiMenu apiMenu = new ApiMenu();
        ApiMenu apiMenu = apiMenuDao.selectById(id);
        apiMenu.setName(name);
        apiMenu.setOrderNum(orderNum);
        int updateCount = apiMenuDao.update(apiMenu);
        return updateCount == 1;
    }

    @Override
    public boolean remove(Long id) {
        int deleteCount = apiMenuDao.delete(id);
        return deleteCount == 1;
    }

    @Override
    public boolean add(ApiMenu apiMenu) {
        int addCount = apiMenuDao.insert(apiMenu);
        return addCount == 1;
    }
}
