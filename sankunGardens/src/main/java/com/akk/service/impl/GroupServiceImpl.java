package com.akk.service.impl;

import com.akk.bean.Group;
import com.akk.bean.Menu;
import com.akk.dao.GroupDao;
import com.akk.dto.GroupDto;
import com.akk.dto.MenuDto;
import com.akk.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHM
 * 2017/9/29 10:16
 */
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupDao groupDao;

    public GroupDto getByIdWithMenu(Long id) {
        //先设置好GroupDto
        GroupDto result = new GroupDto();
        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();

        result.setMenuDtoList(menuDtoList);

        Group group = groupDao.selectMenuListById(id);
        if(group != null) {
            //int i = 0;
            BeanUtils.copyProperties(group, result);
            for(Menu menu : group.getMenuList()) {
                MenuDto menuDto = new MenuDto();
                menuDtoList.add(menuDto);
                BeanUtils.copyProperties(menu, menuDto);
				/*System.out.println(menuDtoList.get(i).getName()+"前置节点"+menuDtoList.get(i).getParentId());
				i++;*/
            }
        }
        return result;
    }
}
