package com.akk.controller.system;

import com.akk.constant.PageCodeEnum;
import com.akk.dto.ArticleDto;
import com.akk.service.ApiMenuService;
import com.akk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 联系方式界面
 */
@Controller
@RequestMapping("/connect")
public class ConnectController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ApiMenuService apiMenuService;

	@RequestMapping
	public String init(Model model, ArticleDto articleDto) {
		//System.out.println("文章标题"+articleDto.getTitle());
		model.addAttribute("list", articleService.ApisearchZlanmu(articleDto, new Long(19), new Long(1)));

		return "/content/connentList";
	}

	/**
	 * 新增页初始化
	 */
	@RequestMapping("/addInit")
	public String addInit(Model model) {
        model.addAttribute("fmenulist", apiMenuService.getApiFMenuList());
        model.addAttribute("zmenulist", apiMenuService.getApiZMenuList());
		return "/content/connectAdd";
	}

	/**
	 * 新增
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add(Model model, ArticleDto articleDto){
		System.out.println("标题:"+articleDto.getTitle()+"内容："+articleDto.getContent());
		if (articleService.add(articleDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		}
		return "/content/connectAdd";
	}

    /**
     * 修改页初始化
     */
    @RequestMapping(value = "/modifyInit")
    public String modifyInit(Model model, @RequestParam("id") Long id){
        model.addAttribute("modifyObj", articleService.getById(id));
        model.addAttribute("fmenulist", apiMenuService.getApiFMenuList());
        model.addAttribute("zmenulist", apiMenuService.getApiZMenuList());
        return "/content/connectModify";
    }

    /**
     * 修改
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String modify(Model model, @PathVariable("id") Long id, ArticleDto articleDto){
        articleDto.setId(id);
        model.addAttribute("modifyObj", articleDto);
        if (articleService.modify(articleDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
        }
        return "/content/connectModify";
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
        return "redirect:/connect";
    }
}
