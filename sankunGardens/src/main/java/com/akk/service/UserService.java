package com.akk.service;

import com.akk.bean.User;
import com.akk.dto.UserDto;

/**
 * Created by KHM
 * 2017/9/26 20:49
 */
public interface UserService {

    /**
     * 校验用户名/密码是否正确
     * @param userDto 待校验dto对象
     * @return true：用户名/密码正确，如果正确，将dto对象里其他属性补齐
     *                false：用户名/密码错误
     */
    boolean validate(UserDto userDto);

    /**
     * 修改
     * @param user
     * @return 影响行数：如用户名将修改成与其他用户的用户名相同，影响行数为0，修改成功，影响行数为1
     */
    int update(User user);

}
