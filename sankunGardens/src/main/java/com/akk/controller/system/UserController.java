package com.akk.controller.system;

import com.akk.bean.User;
import com.akk.constant.PageCodeEnum;
import com.akk.constant.SessionKeyConst;
import com.akk.dto.PageCodeDto;
import com.akk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户信息的操作
 * Created by KHM
 * 2017/10/2 16:32
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @RequestMapping("/update")
    public PageCodeDto UpdateMima(@RequestParam(value = "oldPassword") String oldPassword,
                                  @RequestParam(value = "newPassword") String newPassword){
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);
        PageCodeDto result;
        if(oldPassword.equals(user.getPassword())){
            //执行修改密码操作
            user.setPassword(newPassword);
            int i = userService.update(user);
            if(i==1){
                result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
            } else {
                log.info("【修改密码】 操作数据库出错，i={}",i);
                result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
            }
        }else {
            log.info("【修改密码】 旧密码输入错误}");
            result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL1);
        }
        return result;
    }
}
