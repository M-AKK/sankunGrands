package com.akk.controller.api;

import com.akk.Vo.ResultVO;
import com.akk.dto.AdDto;
import com.akk.service.AdService;
import com.akk.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/19 20:16
 */
@RestController
@RequestMapping("/api/img")
public class ImgController {

    @Autowired
    private AdService adService;

    /**
     * 直接返回所有图片
     */
    @RequestMapping(value = "/allimg", method = RequestMethod.GET)
    public ResultVO getimgbyid(){
        List<AdDto> adDtoList = adService.selectAll();
        return ResultVOUtil.success(adDtoList);
    }

}
