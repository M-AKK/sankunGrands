package com.akk.bean;

import java.util.List;

/**
 * 用来存放查到的菜单列表
 */
public class Group {

	private Long id;
	private String name;
	private List<Menu> menuList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}