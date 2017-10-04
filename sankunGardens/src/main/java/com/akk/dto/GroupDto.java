package com.akk.dto;

import com.akk.bean.Group;

import java.util.List;

public class GroupDto extends Group {

	private Integer pId;
	
	private List<Long> menuIdList;
	
	private List<MenuDto> menuDtoList;


	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public List<Long> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Long> menuIdList) {
		this.menuIdList = menuIdList;
	}


	public List<MenuDto> getMenuDtoList() {
		return menuDtoList;
	}

	public void setMenuDtoList(List<MenuDto> menuDtoList) {
		this.menuDtoList = menuDtoList;
	}

}