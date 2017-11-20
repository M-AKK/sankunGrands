package com.akk.service.impl;

import com.akk.bean.User;
import com.akk.dao.UserDao;
import com.akk.dto.UserDto;
import com.akk.service.UserService;
import com.akk.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by KHM
 * 2017/9/26 20:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean validate(UserDto userDto) {
        if (userDto != null && !CommonUtil.isEmpty(userDto.getName()) && !CommonUtil.isEmpty(userDto.getPassword())) {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            List<User> list = userDao.select(user);
            if(list.size() == 1) {
                //这里就是把根据userDto查找到的user再次复制给userDto，这样上一层就有groupid的值了
                BeanUtils.copyProperties(list.get(0),userDto);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int update(User user) {
        //成功为1
        return userDao.update(user);
    }
}
