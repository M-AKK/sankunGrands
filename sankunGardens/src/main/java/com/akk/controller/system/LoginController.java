package com.akk.controller.system;


import com.akk.constant.PageCodeEnum;
import com.akk.constant.SessionKeyConst;
import com.akk.dto.GroupDto;
import com.akk.dto.UserDto;
import com.akk.service.GroupService;
import com.akk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 登录相关
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private HttpSession session;

	/**
	 * 登录页面
	 */
	@RequestMapping
	public String index() {
		return "/system/login";
	}

	/**
	 * session超时
	 */
	@RequestMapping("/sessionTimeout")
	public String sessionTimeout(Model model) {
		model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
		return "/system/error";
	}
	
	/**
	 * 没有权限访问
	 */
	/*@RequestMapping("/noAuth")
	public String noAuth(Model model) {
		model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.NO_AUTH);
		session.invalidate();
		return "/system/error";
	}*/

	/**
	 * 验证用户名/密码是否正确 验证通过跳转至后台管理首页；
	 * 验证失败，返回至登录页。RedirectAttributes是临时做错误提示的返回，用的是session，所以不能一直存在，用完后就自动销毁了
	 */
	@RequestMapping("/validate")
	public String validate(UserDto userDto, RedirectAttributes attr) {
		if (userService.validate(userDto)) {
			//保存用户信息到session
			session.setAttribute(SessionKeyConst.USER_INFO, userDto);
			GroupDto groupDto = groupService.getByIdWithMenu(userDto.getGroupId());
			//设置用户能访问的菜单列表
			session.setAttribute(SessionKeyConst.MENU_INFO, groupDto.getMenuDtoList());
			/*session.setAttribute(SessionKeyConst.ACTION_INFO, groupDto.getActionDtoList());*/
			return "redirect:/index";//使用重定向的方法
		}
		attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
		return "redirect:/login";//用重定向是为了跳转
	}
}