package com.akk.controller.api;

import com.akk.dto.ApiMenuDto;
import com.akk.service.ApiMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 主页的请求
 * Created by KHM
 * 2017/10/1 19:29
 */
@RestController
@RequestMapping("/index")
public class FirstPageController {

    @Autowired
    private ApiMenuService apiMenuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<ApiMenuDto> getMenuList(){
        return apiMenuService.getMenuList();
    }

}
