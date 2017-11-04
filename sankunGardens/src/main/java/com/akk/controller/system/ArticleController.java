package com.akk.controller.system;

import com.akk.Vo.ResultVO;
import com.akk.constant.PageCodeEnum;
import com.akk.dto.ArticleDto;
import com.akk.service.ApiMenuService;
import com.akk.service.ArticleService;
import com.akk.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author KHM
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ApiMenuService apiMenuService;

	/**
	 * 文章管理页面初始化和查询的功能
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String init(Model model, ArticleDto articleDto) {
		model.addAttribute("list", articleService.searchByPage(articleDto));
		model.addAttribute("searchParam", articleDto);
		return "/content/ArticleList";
	}

    @RequestMapping(value = "/menu")
    @ResponseBody
    public ResultVO getMenu() {
        return ResultVOUtil.success(apiMenuService.getMenuList());
    }


    /**
     * 根据父节点查找父栏目,暂没用到
     * @return
     */
    @RequestMapping(value="/{fid}",method = RequestMethod.GET)
	public String flanmu(@PathVariable("fid") Long fid,
                         Model model, ArticleDto articleDto){
        model.addAttribute("list", articleService.searchFlanmuByPage(articleDto, fid));
        model.addAttribute("searchParam", articleDto);
        return "/content/ArticleList";
    }

    /**
     * 根据父、子节点查找文章
     * @param fid
     * @param zid
     * @param model
     * @param articleDto
     * @return
     */
    @RequestMapping(value="/{fid}/{zid}",method = RequestMethod.GET)
    public String zlanmu(@PathVariable("fid") Long fid, @PathVariable("zid") Long zid,
                         Model model, ArticleDto articleDto){
        if(articleService.searchZlanmuByPage(articleDto, fid, zid)!=null){
            model.addAttribute("list", articleService.searchZlanmuByPage(articleDto, fid, zid));
        } else {
            model.addAttribute("list", null);
        }
        return "/content/ArticleList";
    }

    /**
     * 新增页初始化
     */
    @RequestMapping("/addInit")
    public String addInit(Model model, @RequestParam("id") Long id) {
        if(id!=null){
            model.addAttribute("modifyObj", articleService.getById(id));
        }
        else {
            model.addAttribute("modifyObj", null);
        }
        return "/content/ArticleAdd";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Model model, ArticleDto articleDto){
        if (articleService.add(articleDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        return "/content/ArticleAdd";
    }

    /**
     * 修改页初始化
     */
    @RequestMapping(value = "/modifyInit")
    public String modifyInit(Model model, @RequestParam("id") Long id){
        model.addAttribute("modifyObj", articleService.getById(id));
        model.addAttribute("menulist", apiMenuService.getMenuList());
    	return "/content/ArticleModify";
	}

    /**
     * 修改
     * @param model
     * @return
     */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Model model, ArticleDto articleDto){
        model.addAttribute("modifyObj", articleDto);
        if (articleService.modify(articleDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
        }
        return "/content/ArticleModify";
    }

    /**
     * 删除
     * @param id
     * @param model
     * @return
     */
	@RequestMapping(value = "/remove")
	public String remove(@RequestParam("id") Long id, Model model){
        if(articleService.remove(id)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
        }
        return "redirect:/articles";
    }

}