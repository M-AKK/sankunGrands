package com.akk.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KHM
 * 2017/10/21 19:52
 */
@Controller
@RequestMapping(value = "/lanmu")
public class LanmuController {

        @RequestMapping
        public String init() {
            return "/content/LanmuList";
        }

}
