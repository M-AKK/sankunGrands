package com.akk.service;

import com.akk.dto.GroupDto;

/**
 * Created by KHM
 * 2017/9/29 10:15
 */
public interface GroupService {

    /**
     * 根据主键获取用户组(包括用户组对应可以访问的菜单和动作，现没有动作了，只有菜单)
     * @param id
     * @return 用户组对象
     */
    GroupDto getByIdWithMenu(Long id);
}
