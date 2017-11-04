package com.akk.controller.system;

import com.akk.constant.PageCodeEnum;
import com.akk.dto.AdDto;
import com.akk.service.AdService;
import com.akk.service.ImgGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片列表
 * @author KHM
 */
@Controller
@RequestMapping("/ad")
public class AdController {

	@Autowired
	private AdService adService;

	@Autowired
	private ImgGroupService imgGroupService;

	/**
	 * 广告管理页初始化(点广告管理菜单进入的第一个页面)
	 */
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		AdDto adDto = new AdDto();
		model.addAttribute("list", adService.searchByPage(adDto));
		model.addAttribute("searchParam", adDto);
		return "/content/adList";
	}

	/**
	 * 查询
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, AdDto adDto) {
		model.addAttribute("list", adService.searchByPage(adDto));
		model.addAttribute("searchParam", adDto);
		return "/content/adList";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") Long id,Model model) {
		if(adService.remove(id)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
		}
		//这是跳转到方法
		return "forward:/ad";
	}

	/**
	 * 新增页初始化
	 */
	@RequestMapping(value = "/addInit", method = RequestMethod.GET)
	public String addInit(Model model) {
		model.addAttribute("imggroup", imgGroupService.select());
		return "/content/adAdd";
	}

	/**
	 * 新增
	 */
	@RequestMapping(value = "/add")
	public String add(AdDto adDto, Model model) {
        model.addAttribute("imggroup", imgGroupService.select());
		if (adService.add(adDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		}
		return "/content/adAdd";
	}

	/**
	 * 修改页初始化
	 */
	@RequestMapping(value = "/modifyInit", method = RequestMethod.POST)
	public String modifyInit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("imggroup", imgGroupService.select());
		model.addAttribute("modifyObj", adService.getById(id));
		return "/content/adModify";
	}

	/**
	 * 修改
	 */
	@RequestMapping("/modify")
	public String modify(Model model, AdDto adDto) {
        model.addAttribute("imggroup", imgGroupService.select());
		model.addAttribute("modifyObj", adDto);
		if (adService.modify(adDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
		}
		return "/content/adModify";
	}
}
