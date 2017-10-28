package com.akk.controller.api;

import com.akk.Vo.ResultVO;
import com.akk.bean.ApiMenu;
import com.akk.service.ApiMenuService;
import com.akk.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.akk.constant.PageCodeEnum.ADD_SUCCESS;
import static com.akk.constant.PageCodeEnum.MODIFY_FAIL;
import static com.akk.constant.PageCodeEnum.REMOVE_SUCCESS;


/**
 * Created by KHM
 * 2017/10/25 15:08
 */
@RestController
@RequestMapping("/lanmu")
public class LnmuController {

    @Autowired
    private ApiMenuService apiMenuService;

    @RequestMapping(value = "/update")
    public ResultVO updatelanmu(@RequestParam("id") Long id,
                              @RequestParam("name") String name,
                              @RequestParam("orderNum") Integer orderNum){
        if(apiMenuService.modify(id, name, orderNum)){
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(MODIFY_FAIL.getCode(), MODIFY_FAIL.getMsg());
        }
    }

    @RequestMapping(value = "/delete")
    public ResultVO deletelanmu(@RequestParam("id") Long id){
        if(apiMenuService.remove(id)){
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(REMOVE_SUCCESS.getCode(), REMOVE_SUCCESS.getMsg());
        }
    }

    /**
     * 增加父栏目(id为递增，url为空，)
     * @param name
     * @param orderNum
     * @return
     */
    @RequestMapping(value = "/addFlanmu")
    public ResultVO addFlanmu(@RequestParam("name") String name,
                             @RequestParam("orderNum") Integer orderNum
                                ){
        ApiMenu apiMenu = new ApiMenu();
        apiMenu.setName(name);
        apiMenu.setUrl("");
        apiMenu.setOrderNum(orderNum);
        apiMenu.setParentId(new Long(0));
        apiMenu.setLink("");
        if(apiMenuService.add(apiMenu)){
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(ADD_SUCCESS.getCode(), ADD_SUCCESS.getMsg());
        }
    }

    @RequestMapping(value = "/addZlanmu")
    public ResultVO addZlanmu(@RequestParam("name") String name,
                              @RequestParam("orderNum") Integer orderNum,
                              @RequestParam("parentId") Long parentId,
                              @RequestParam("link") String link
                                ){
        ApiMenu apiMenu = new ApiMenu();
        apiMenu.setName(name);
        apiMenu.setUrl("articles/"+parentId+orderNum);
        apiMenu.setOrderNum(orderNum);
        apiMenu.setParentId(parentId);
        apiMenu.setLink(link);
        if(apiMenuService.add(apiMenu)){
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(ADD_SUCCESS.getCode(), ADD_SUCCESS.getMsg());
        }
    }
}
