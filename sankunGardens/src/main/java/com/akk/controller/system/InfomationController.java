package com.akk.controller.system;

import com.akk.constant.SessionKeyConst;
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
        model.addAttribute("user", request.getSession().getAttribute(SessionKeyConst.USER_INFO));
        return "/content/Infomation";
    }
}
