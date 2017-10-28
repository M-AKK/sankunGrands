package com.akk.controller.system;

import com.akk.bean.User;
import com.akk.constant.SessionKeyConst;
import com.akk.dto.UserDto;
import com.akk.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by KHM
 * 2017/10/12 20:11
 */
@Controller
@RequestMapping(value = "/infomation")
public class InfomationController {

    @RequestMapping
    public String init(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionKeyConst.USER_INFO);
        /*UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setUpdateTime1(DateUtil.dateFormat2(user.getUpdateTime(), 0, 16));*/
        String updateTime = DateUtil.dateFormat2(user.getUpdateTime(), 0, 16);
        model.addAttribute("updateTime", updateTime);
        model.addAttribute("user", user);
        return "/content/Infomation";
    }
}
