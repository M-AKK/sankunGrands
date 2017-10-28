package com.akk.controller.system;

import com.akk.bean.User;
import com.akk.constant.PageCodeEnum;
import com.akk.constant.SessionKeyConst;
import com.akk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import static com.akk.util.MD5Util.getMD5;

/**
 * 用户信息的操作
 * Created by KHM
 * 2017/10/2 16:32
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/updatemima")
    public String UpdateMima(@RequestParam(value = "oldPassword") String oldPassword,
                             @RequestParam(value = "newPassword") String newPassword,
                             Model model, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(SessionKeyConst.USER_INFO);
        System.out.println("新密码："+getMD5(oldPassword)+"\n"
                            +"老密码:" + user.getPassword());
        if(getMD5(oldPassword).equals(user.getPassword())){
            //执行修改密码操作
            user.setPassword(getMD5(newPassword));
            int i = userService.update(user);
            if(i==1){
                model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
            } else {
                log.info("【修改密码】 操作数据库出错，i={}",i);
                model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
            }
        } else {
            log.info("【修改密码】 旧密码输入错误");
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL1);
        }
        return "/system/index";
    }

    @RequestMapping("/updateinfo")
    public String UpdateInfo(@RequestParam(value = "username") String username,
                               @RequestParam(value = "chName") String chName,
                               Model model, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(SessionKeyConst.USER_INFO);

        user.setName(username);
        user.setChName(chName);
        int i = userService.update(user);
        if(i==1){
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            log.info("【修改用户名】 操作数据库出错，i={}",i);
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
        }
        return "redirect:/infomation";
    }
}
